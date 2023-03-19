package dev.login.loginApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //lets framework know to instantiate the class for us
    private UserRepository userRepository; //reference to the user repo, can b initialized with a constructor or autowired
    public User createNewUser(User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setName(user.getName());
        String password= bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        User newUser= userRepository.insert(user);
        return newUser;
    }
    public List<User> allUsers(){
        return userRepository.findAll();
    }
    public Optional<User> singleUser(String username){
        return userRepository.findUserByUsername(username);
    }

}