package yte.intern.springsecurity.login.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.intern.springsecurity.login.entity.Authority;
import yte.intern.springsecurity.login.entity.Users;
import yte.intern.springsecurity.login.repository.UserRepository;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabasePopulator {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        userRepository.save(new Users(null, "user", passwordEncoder.encode("user"), List.of(new Authority("USER"))));
        userRepository.save(new Users(null, "admin", passwordEncoder.encode("admin"), List.of(new Authority("USER"), new Authority("ADMIN"))));
    }
}
