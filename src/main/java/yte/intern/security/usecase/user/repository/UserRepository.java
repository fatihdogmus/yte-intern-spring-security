package yte.intern.security.usecase.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.security.usecase.user.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);

	void deleteByUsername(String username);

	boolean existsByUsername(String username);

}
