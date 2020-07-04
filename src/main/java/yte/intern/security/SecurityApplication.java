package yte.intern.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yte.intern.security.security.CustomUserDetailsManager;
import yte.intern.security.security.entity.Authority;
import yte.intern.security.security.entity.Users;

import javax.annotation.PostConstruct;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityApplication {

	private final CustomUserDetailsManager customUserDetailsManager;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@PostConstruct
	public void initSecurityData() {
		Users adminUser = new Users(1L, "admin", "admin", Set.of(new Authority(1L, "READ"), new Authority(2L, "WRITE")));
		Users normalUser = new Users(2L, "user", "user", Set.of(new Authority(1L, "READ")));
		Users sysUser = new Users(3L, "sys", "sys", Set.of());

		customUserDetailsManager.createUser(adminUser);
		customUserDetailsManager.createUser(normalUser);
		customUserDetailsManager.createUser(sysUser);

	}

}
