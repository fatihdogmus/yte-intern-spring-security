package yte.intern.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yte.intern.security.security.util.DatabasePopulator;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityApplication {

	private final DatabasePopulator databasePopulator;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@PostConstruct
	public void initSecurityData() {
		databasePopulator.populateDatabaseAfterInit();
	}

}
