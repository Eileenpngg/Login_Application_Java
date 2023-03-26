package dev.login.loginApplication.authentication;

import dev.login.loginApplication.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> addNewUser(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.createNewUser(request));
    }

    @PostMapping("/authenticate")
//request body would be converted to a map of a key is string, value is string
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
