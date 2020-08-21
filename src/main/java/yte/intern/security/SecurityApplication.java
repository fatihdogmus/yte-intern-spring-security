package yte.intern.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}


}
