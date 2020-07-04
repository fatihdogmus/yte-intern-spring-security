package yte.intern.security.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.security.security.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
