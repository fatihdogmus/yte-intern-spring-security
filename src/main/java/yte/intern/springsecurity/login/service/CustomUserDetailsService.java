package yte.intern.springsecurity.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yte.intern.springsecurity.login.entity.Authority;
import yte.intern.springsecurity.login.entity.CustomUser;
import yte.intern.springsecurity.login.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        userRepository.save(new CustomUser(null, "user", passwordEncoder.encode("user"), List.of(new Authority("USER"))));
        userRepository.save(new CustomUser(null, "admin", passwordEncoder.encode("admin"), List.of(new Authority("USER"), new Authority("ADMIN"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username %s is not present".formatted(username)));
    }
}
