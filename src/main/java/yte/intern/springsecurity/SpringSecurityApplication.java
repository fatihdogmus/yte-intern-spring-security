package yte.intern.springsecurity;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import yte.intern.springsecurity.entity.Authority;
import yte.intern.springsecurity.entity.Users;
import yte.intern.springsecurity.repository.UserRepository;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringSecurityApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		Users user = new Users(null, "user", "user", List.of(new Authority("USER")));
		userRepository.save(user);

		Users admin = new Users(null, "admin", "admin", List.of(new Authority("ADMIN")));
		userRepository.save(admin);
	}


}
