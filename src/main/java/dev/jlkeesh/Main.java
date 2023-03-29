package dev.jlkeesh;


import dev.jlkeesh.domains.AuthUser;
import dev.jlkeesh.repository.AuthUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean
    ApplicationRunner runner(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            AuthUser authUser = AuthUser.builder()
                    .username("john")
                    .role(AuthUser.Role.USER)
                    .password(passwordEncoder.encode("123"))
                    .build();
            authUserRepository.save(authUser);
        };
    }


}