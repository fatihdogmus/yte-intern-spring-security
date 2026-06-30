package yte.intern.springsecurity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserDetailsRepository extends JpaRepository<CustomUserDetails, Long> {

    Optional<CustomUserDetails> findByUsername(String username);
}