package com.maz.testsecurity.repository;

import com.maz.testsecurity.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
