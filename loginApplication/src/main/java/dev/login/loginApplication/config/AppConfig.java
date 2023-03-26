package dev.login.loginApplication.config;

import dev.login.loginApplication.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//picks up class with @config annotation and inject all the beans declared in this class
@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final UserRepository repository;
    //bean should always be public
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    @Bean //responsible for fetching userDetails and encode password etc. //Dao-> Data access object
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider(); //needs to specify 2 properites, userDetailsService to fetch userDetails from data
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    //responsible to manage the authentication
    @Bean // AuthenticationConfig, holds information about the authentication manager
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
