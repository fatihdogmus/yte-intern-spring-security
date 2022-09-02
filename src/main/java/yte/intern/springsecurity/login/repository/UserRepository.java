package yte.intern.springsecurity.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springsecurity.login.entity.CustomUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CustomUser, Long> {
    Optional<CustomUser> findByUsername(String username);

}
