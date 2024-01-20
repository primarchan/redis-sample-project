package org.example.rediscacheproject.domain.user.repository;

import org.example.rediscacheproject.domain.user.entity.RedisHashUser;
import org.springframework.data.repository.CrudRepository;

public interface RedisHashUserRepository extends CrudRepository<RedisHashUser, Long> {
}
