package yte.intern.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springsecurity.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
