package dev.login.loginApplication;

import org.springframework.boot.SpringApplication; // class contains a run method which accepts app name as arg
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication; //used to let the compiler know what this class does
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
}
