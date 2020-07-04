package yte.intern.security.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.security.security.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByUsername(String username);

	void deleteByUsername(String username);

	boolean existsByUsername(String username);

}
