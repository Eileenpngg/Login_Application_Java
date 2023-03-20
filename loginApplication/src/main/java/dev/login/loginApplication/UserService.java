package dev.login.loginApplication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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

    public String authenticate(User user) throws UsernameNotFoundException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Optional<User> opUser= userRepository.findUserByUsername(user.getUsername());
        if(opUser.isPresent()){
            User dbuser= opUser.get();
            if(bCryptPasswordEncoder.matches(user.getPassword(), dbuser.getPassword()))
                return "Authenticated User";
            else
                return "Incorrect Password";
        }
        throw
                new UsernameNotFoundException("User not found");

    }

}