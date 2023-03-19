package dev.login.loginApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired //lets framework know to instantiate the class for us
    private UserRepository userRepository; //reference to the user repo, can b initialized with a constructor or autowired
    @Autowired
    public User createNewUser(User user){
        User newUser= new User();
        newUser.setName(user.getName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.insert(user);
        return user;
    }
    public List<User> allUsers(){
        return userRepository.findAll();
    }
    public Optional<User> singleUser(String username){
        return userRepository.findUserByUsername(username);
    }

}