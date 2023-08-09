package yte.intern.springsecurity.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springsecurity.login.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

}
