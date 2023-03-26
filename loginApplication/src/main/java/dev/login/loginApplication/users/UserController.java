package dev.login.loginApplication.users;

import dev.login.loginApplication.authentication.AuthenticationRequest;
import dev.login.loginApplication.authentication.AuthenticationResponse;
import dev.login.loginApplication.authentication.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users") //any endpoint that start with this will be handled by this controller
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    private UserRepository userRepository;
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers(){
//        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{username}")
//    //@pathvariable is kind of like params and convert it into Object Id called id
//    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String username){
//        return new ResponseEntity<Optional<User>>(userService.singleUser(username), HttpStatus.OK);
//    }
//    @PostMapping("/register")
//    //request body would be converted to a map of a key is string, value is string
//    public ResponseEntity<String> addNewUser(@RequestBody User user){
//        userService.createNewUser(user);
//        return new ResponseEntity<String>(user.getPassword(), HttpStatus.CREATED);
//    }
//@GetMapping("/login")
////request body would be converted to a map of a key is string, value is string
//public ResponseEntity<String> login(@RequestBody User user){
//    return new ResponseEntity<>(userService.authenticate(user), HttpStatus.OK);
//}

//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> addNewUser(@RequestBody RegisterRequest request){
//       return ResponseEntity.ok(userService.createNewUser(request));
//    }
//
//    @GetMapping("/authenticate")
////request body would be converted to a map of a key is string, value is string
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
//        return ResponseEntity.ok(userService.authenticate(request));
//    }

}

//        ResponseEntity<User>(userService.createNewUser(payload.get("userName"), payload.get("name"), payload.get("password"), payload.get(manager))
