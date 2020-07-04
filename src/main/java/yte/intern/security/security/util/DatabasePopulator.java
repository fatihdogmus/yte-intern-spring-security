package yte.intern.security.security.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yte.intern.security.security.CustomUserDetailsManager;
import yte.intern.security.security.entity.Authority;
import yte.intern.security.security.entity.Users;
import yte.intern.security.security.repository.AuthorityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DatabasePopulator {

	private final CustomUserDetailsManager customUserDetailsManager;
	private final AuthorityRepository authorityRepository;

	@Transactional
	public void populateDatabaseAfterInit() {

		List<Authority> savedAuthorities = authorityRepository.saveAll(Set.of(new Authority(null, "READ"), new Authority(null, "WRITE")));
		Users adminUser = new Users(null, "admin", "admin", Set.copyOf(savedAuthorities));
		Users normalUser = new Users(null, "user", "user", Set.of(savedAuthorities.get(0)));
		Users sysUser = new Users(null, "sys", "sys", Set.of());

		customUserDetailsManager.createUser(adminUser);
		customUserDetailsManager.createUser(normalUser);
		customUserDetailsManager.createUser(sysUser);
	}
}
