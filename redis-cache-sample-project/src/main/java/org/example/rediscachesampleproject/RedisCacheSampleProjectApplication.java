package org.example.rediscachesampleproject;

import lombok.RequiredArgsConstructor;
import org.example.rediscachesampleproject.domain.user.User;
import org.example.rediscachesampleproject.domain.user.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class RedisCacheSampleProjectApplication implements ApplicationRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheSampleProjectApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        userRepository.save(User.builder().name("Kevin").email("kevin@gmail.com").build());
        userRepository.save(User.builder().name("Tony").email("tony@gmail.com").build());
        userRepository.save(User.builder().name("Bob").email("bob@gmail.com").build());
        userRepository.save(User.builder().name("duke").email("duke@gmail.com").build());
    }

}
