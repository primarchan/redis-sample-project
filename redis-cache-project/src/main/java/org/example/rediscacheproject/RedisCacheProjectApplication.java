package org.example.rediscacheproject;

import lombok.RequiredArgsConstructor;
import org.example.rediscacheproject.domain.user.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class RedisCacheProjectApplication implements ApplicationRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheProjectApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

}
