package tubitak.yte.securitydemo.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);
	void deleteByUsername(String username);
	boolean existsByUsername(String username);
}
