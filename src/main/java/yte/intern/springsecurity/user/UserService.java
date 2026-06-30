package yte.intern.springsecurity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CustomUserDetailsRepository customUserDetailsRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CustomUserDetails registerUser(String username, String password) {
        if (customUserDetailsRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("User already exists: " + username);
        }
        CustomUserDetails user = new CustomUserDetails(username, passwordEncoder.encode(password), new HashSet<>());
        return customUserDetailsRepository.save(user);
    }

    @Transactional
    public CustomUserDetails addAuthoritiesToUser(String username, Set<String> authorityNames) {
        CustomUserDetails user = customUserDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        Set<Authority> authoritiesToAdd = new HashSet<>();
        for (String name : authorityNames) {
            Authority authority = authorityRepository.findByAuthority(name)
                    .orElseGet(() -> authorityRepository.save(new Authority(name)));
            authoritiesToAdd.add(authority);
        }

        user.getAuthorities().addAll(authoritiesToAdd);
        return customUserDetailsRepository.save(user);
    }
}