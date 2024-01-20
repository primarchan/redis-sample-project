package org.example.rediscacheproject.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.rediscacheproject.domain.user.entity.RedisHashUser;
import org.example.rediscacheproject.domain.user.entity.User;
import org.example.rediscacheproject.domain.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("redis-hash/{id}")
    public RedisHashUser getRedisHashUser(@PathVariable Long id) {
        return userService.getHashUser(id);
    }

    @GetMapping("spring-cache/{id}")
    public User getCachinghUser(@PathVariable Long id) {
        return userService.getCachingUser(id);
    }

}
