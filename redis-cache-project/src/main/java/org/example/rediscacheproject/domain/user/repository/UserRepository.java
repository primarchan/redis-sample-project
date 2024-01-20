package org.example.rediscacheproject.domain.user.repository;

import org.example.rediscacheproject.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
