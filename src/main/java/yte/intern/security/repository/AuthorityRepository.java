package yte.intern.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.security.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
