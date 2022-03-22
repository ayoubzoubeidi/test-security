package com.maz.testsecurity;

import com.maz.testsecurity.domain.Authority;
import com.maz.testsecurity.domain.Role;
import com.maz.testsecurity.domain.User;
import com.maz.testsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TestSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSecurityApplication.class, args);
    }


    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return (String... args) -> {
            userRepository.deleteAll();
            userRepository.saveAndFlush(User.builder()
                    .username("ayoub")
                    .password(passwordEncoder.encode("ayoub"))
                    .role(Role.builder().name("admin").authority(Authority.builder().permission("read.all").build()).build())
                    .build());
        };
    }

}
