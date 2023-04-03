package dev.login.loginApplication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
@RequiredArgsConstructor
public class SecretPage {
    @GetMapping("/secretPage")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<String> secret(){
        return ResponseEntity.ok("Secret Page");
    }
}
