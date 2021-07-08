package yte.intern.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springsecurity.domain.CustomUser;

import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {

    Optional<CustomUser> findByUsername(String username);
}
