package dev.jlkeesh;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jlkeesh.config.SessionUser;
import dev.jlkeesh.customrepository.User;
import dev.jlkeesh.customrepository.UserRepo;
import dev.jlkeesh.jparepository.PostRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@OpenAPIDefinition
@EnableJpaAuditing
public class Main {
    private final PostRepository postRepository;
    private final ObjectMapper objectMapper;
    private final UserRepo userRepository;
    private final SessionUser sessionUser;

    public Main(
            PostRepository postRepository,
            ObjectMapper objectMapper,
            UserRepo userRepository, SessionUser sessionUser) {
        this.postRepository = postRepository;
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
        this.sessionUser = sessionUser;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    /*@Bean*/
    CommandLineRunner runner() {
        return args -> {
            URL src = new URL("https://jsonplaceholder.typicode.com/users");
            List<User> users = objectMapper.readValue(src, new TypeReference<>() {
            });
            userRepository.saveAll(users);
        };
    }


    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(sessionUser.getId());
    }
}