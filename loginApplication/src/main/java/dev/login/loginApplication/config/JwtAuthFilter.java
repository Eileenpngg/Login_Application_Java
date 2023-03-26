package dev.login.loginApplication.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
//A filter per request
@Service //can use either repo, component or service as it both extends the class
@RequiredArgsConstructor //create constructor with any declared final field
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    //user our own methods because we want to fetch user from database
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, //intercept request
            HttpServletResponse response, //provide new data to response
            FilterChain filterChain //it contains list of filters we need to execute, and when we call doFilter, it will execute the next filter it will need to execute
    ) throws ServletException, IOException{
        //prt of request, contains JWT token/ bearer token
        final String authenticationHeader= request.getHeader("Authorization");
        final String jwtToken;
        final String userName;
        if(authenticationHeader==null || !authenticationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response); //pass to next filter if above condition met
            return;
        }
        //extract token from authenticationHeader
        jwtToken= authenticationHeader.substring(7); //position number with a space =7 (Bearer )
        userName= jwtService.extractUsername(jwtToken);
        //check if user is authenticated (SecurityContextHolder) , if not authenticated (==null) and have username, need to get user details from database
        //check is user and token is valid
        if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails= this.userDetailsService.loadUserByUsername(userName);
            if (jwtService.isTokenValid(jwtToken, userDetails)){
                //object is needed by spring and security context holder to update security context, if valid
                UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null, //no credentails when creating user thus null
                        userDetails.getAuthorities()
                );
                //extend authentication token ith details of request and update auth token
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
