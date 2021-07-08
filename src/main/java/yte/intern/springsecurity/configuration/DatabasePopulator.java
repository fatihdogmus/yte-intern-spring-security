package yte.intern.springsecurity.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.springsecurity.domain.Authority;
import yte.intern.springsecurity.domain.CustomUser;
import yte.intern.springsecurity.repositories.AuthorityRepository;
import yte.intern.springsecurity.repositories.CustomUserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabasePopulator {

    private final AuthorityRepository authorityRepository;
    private final CustomUserRepository customUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabasePopulator(final AuthorityRepository authorityRepository,
                             final CustomUserRepository customUserRepository,
                             final PasswordEncoder passwordEncoder) {
        this.authorityRepository = authorityRepository;
        this.customUserRepository = customUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void populateDatabase() {
        Authority userAuthority = authorityRepository.save(new Authority(null, "USER", new HashSet<>()));
        Authority adminAuthority = authorityRepository.save(new Authority(null, "ADMIN", new HashSet<>()));

        CustomUser admin = new CustomUser(null, "admin", passwordEncoder.encode("admin"), Set.of(userAuthority, adminAuthority));
        customUserRepository.save(admin);

        CustomUser user = new CustomUser(null, "user", passwordEncoder.encode("user"), Set.of(userAuthority));
        customUserRepository.save(user);

        System.out.println(customUserRepository.findByUsername("admin").get().getPassword());
    }
}
