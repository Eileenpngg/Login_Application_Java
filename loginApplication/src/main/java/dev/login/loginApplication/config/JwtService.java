package dev.login.loginApplication.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="4B6250655367566B5970337336763979244226452948404D635166546A576D5A";
    //jwtToken: json web token consisting of headers , payload and signature
    //headers: usually is the type of jwt and the sign in alg e.g HS256
    //payload is the claims about the entity(User), e.g name authorities etc. , claims can be registered, private, public
    public String extractUsername(String jwtToken) {
        return extractClaims(jwtToken, Claims::getSubject); //getSubject is the username
    }


    //!!!!!!!!!!!!!!READDDDD UPPP
    public <T> T extractClaims(String jwtToken, Function<Claims, T> claimsResolver){
        final Claims claims= extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> claims, //anything i want to pass into my token sucha s authorities , name
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 *60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    //userDetails is required toc heck if the token belongs to the user
    public boolean isTokenValid(String jwtToken, UserDetails userDetails){
        final String username= extractUsername(jwtToken);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(jwtToken);

    }
    public boolean isTokenExpired(String jwtToken){
        return extractExpiration(jwtToken).before(new Date()); //before todays date
    };

    private Date extractExpiration(String jwtToken){
        return extractClaims(jwtToken, Claims::getExpiration);
    }
    private Claims extractAllClaims(String jwtToken){
        //parse builder to parse token
        //setSignInKey because to decode a token need sign in key
        //A sign in  key is a secret to digitally sign the JWT (part of signature and ensure it claims who it is)
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody(); //getBody gets all the claim from the token passed in
    }

    private Key getSignInKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); //an algorithim in the jwt headers
    }


}
