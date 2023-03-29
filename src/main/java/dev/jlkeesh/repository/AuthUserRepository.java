package dev.jlkeesh.repository;

import dev.jlkeesh.domains.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    @Query("select a from AuthUser a where upper(a.username) = upper(?1)")
    Optional<AuthUser> findByUsername(String username);
}