package yte.intern.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.security.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}
