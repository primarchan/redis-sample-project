package org.example.rediscacheproject.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.rediscacheproject.domain.user.entity.RedisHashUser;
import org.example.rediscacheproject.domain.user.entity.User;
import org.example.rediscacheproject.domain.user.repository.RedisHashUserRepository;
import org.example.rediscacheproject.domain.user.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

import static org.example.rediscacheproject.config.CacheConfig.CACHE1;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RedisTemplate<String, User> userRedisTemplate;
    private final RedisHashUserRepository redisHashUserRepository;
    private final RedisTemplate<String, Object> objectRedisTemplate;


    public User getUser(final Long id) {
        final String USER_REDIS_KEY = "users:%d".formatted(id);
        // User cachedUser = userRedisTemplate.opsForValue().get(USER_REDIS_KEY);
        User cachedUser = (User) objectRedisTemplate.opsForValue().get(USER_REDIS_KEY);

        if (cachedUser != null) {
            return cachedUser;
        }

        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        // userRedisTemplate.opsForValue().set(USER_REDIS_KEY, user, Duration.ofSeconds(30));
        objectRedisTemplate.opsForValue().set(USER_REDIS_KEY, user, Duration.ofSeconds(30));

        return user;
    }

    public RedisHashUser getHashUser(final Long id) {
        RedisHashUser redisHashUser = redisHashUserRepository.findById(id).orElseGet(() -> {
            User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
            return redisHashUserRepository.save(
                    RedisHashUser.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .email(user.getEmail())
                            .createdAt(user.getCreatedAt())
                            .updatedAt(user.getUpdatedAt())
                            .build()
            );
        });

        return redisHashUser;
    }

    @Cacheable(cacheNames = CACHE1, key = "'user:' + #id")
    public User getCachingUser(final Long id) {

        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
