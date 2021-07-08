package yte.intern.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yte.intern.springsecurity.configuration.DatabasePopulator;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityApplication {

	private final DatabasePopulator databasePopulator;

	public SpringSecurityApplication(final DatabasePopulator databasePopulator) {
		this.databasePopulator = databasePopulator;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@PostConstruct
	public void populateDatabase() {
		databasePopulator.populateDatabase();
	}


}
