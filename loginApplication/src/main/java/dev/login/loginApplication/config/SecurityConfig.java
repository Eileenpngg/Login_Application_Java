package dev.login.loginApplication.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//class is used to bind the auth filter together with the others
//once application start, spring will look for security filter chain bean
//responsible for configuring HTTp security of application
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter; //needs to be final so it will be authomatically injected by spring
    private final AuthenticationProvider authenticationProvider;

    @Bean //bean should always be public not private
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()//disable csrf
                .authorizeHttpRequests()//all application has white list, open to everyone
                .requestMatchers("/api/users/auth/**")//accepts a list of patterns //allow all methods because all the users api requires authentication
                .permitAll()
                .anyRequest()//all the other request will be authenticated
                .authenticated()
                .and()//configure session management, session should be stateless to ensure each request will be authenticated
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider) //tell spring which auth provider you want to use
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); //execute filter before the filter called username password authentication filter because
        return http.build();
    }
}
