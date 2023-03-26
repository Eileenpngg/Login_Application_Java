package dev.login.loginApplication.users;
import dev.login.loginApplication.authentication.AuthenticationRequest;
import dev.login.loginApplication.authentication.AuthenticationResponse;
import dev.login.loginApplication.authentication.RegisterRequest;
import dev.login.loginApplication.config.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

//lets framework know to instantiate the class for us
    private UserRepository userRepository; //reference to the user repo, can b initialized with a constructor or autowired
    private JwtService jwtService;

    private AuthenticationManager authenticationManager;
//    public List<User> allUsers(){
//        return userRepository.findAll();
//    }
//    public Optional<User> singleUser(String username){
//        return userRepository.findUserByUsername(username);
//    }

//    public AuthenticationResponse createNewUser(RegisterRequest request) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        var user= User.builder()
//                .name(request.getName())
//                .username(request.getUsername())
//                .password(bCryptPasswordEncoder.encode(request.getPassword()))
//                .role(Role.USER)
//                .build();
//        userRepository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    };
//
//    public AuthenticationResponse authenticate(AuthenticationRequest request) throws UsernameNotFoundException {
//        authenticationManager.authenticate( //authentication manager will throw a exception will be thrown is username and password is not correct
//                new UsernamePasswordAuthenticationToken(
//                        request.getUsername(),
//                        request.getPassword()
//                )
//        );
//        //if username and password is correct, generate a token and send it back
//        var user= userRepository.findUserByUsername(request.getUsername())
//                .orElseThrow();
//        var jwtToken = jwtService.generateToken(user); //once got this user, generate a token user user object and return authentication response
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }

//Authentication manager bean has a method called authenticate which allows us to authenticate a user based on the username and password
//    public User createNewUser(User user){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        user.setName(user.getName());
//        String password= bCryptPasswordEncoder.encode(user.getPassword());
//        user.setPassword(password);
//        User newUser= userRepository.insert(user);
//        return newUser;
//    }

//    public String authenticate(User user) throws UsernameNotFoundException {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        Optional<User> opUser= userRepository.findUserByUsername(user.getUsername());
//        if(opUser.isPresent()){
//            User dbuser= opUser.get();
//            if(bCryptPasswordEncoder.matches(user.getPassword(), dbuser.getPassword()))
//                return "Authenticated User";
//            else
//                return "Incorrect Password";
//        }
//        throw
//                new UsernameNotFoundException("User not found");
//
//    }

}