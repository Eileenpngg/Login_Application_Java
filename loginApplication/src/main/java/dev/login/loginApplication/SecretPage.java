package dev.login.loginApplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secretPage")
public class SecretPage {
    @GetMapping
    public ResponseEntity<String> secret(){
        return ResponseEntity.ok("Secret Page");
    }
}
