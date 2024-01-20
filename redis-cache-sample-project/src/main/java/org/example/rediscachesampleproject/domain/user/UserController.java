package org.example.rediscachesampleproject.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final JedisPool jedisPool;

    @GetMapping("/{id}/email")
    public String getUserEmail(@PathVariable Long id) {

        try (Jedis jedis = jedisPool.getResource()) {
            String userEmailRedisKey = "users:%d:email".formatted(id);

            String userEmail = jedis.get(userEmailRedisKey);

            if (userEmail != null) {
                return userEmail;
            }

            userEmail =userRepository.findById(id).orElseThrow(RuntimeException::new).getEmail();

            jedis.set(userEmailRedisKey, userEmail);
            jedis.setex(userEmailRedisKey, 30, userEmail);

            return userEmail;
        }
    }

}
