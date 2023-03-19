package dev.login.loginApplication;

import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users") //any endpoint that start with this will be handled by this controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    //@pathvariable is kind of like params and convert it into Object Id called id
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String username){
        return new ResponseEntity<Optional<User>>(userService.singleUser(username), HttpStatus.OK);
    }
    @PostMapping("/register")
    //request body would be converted to a map of a key is string, value is string
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        userService.createNewUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}

