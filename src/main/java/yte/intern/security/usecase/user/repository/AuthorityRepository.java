package yte.intern.security.usecase.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.security.usecase.user.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
