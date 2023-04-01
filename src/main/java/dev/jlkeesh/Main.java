package dev.jlkeesh;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jlkeesh.jparepository.Post;
import dev.jlkeesh.jparepository.PostRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition
public class Main {
    private final PostRepository postRepository;
    private final ObjectMapper objectMapper;

    public Main(PostRepository postRepository, ObjectMapper objectMapper) {
        this.postRepository = postRepository;
        this.objectMapper = objectMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    /*@Bean*/
    CommandLineRunner runner() {
        return args -> {
            URL src = new URL("https://jsonplaceholder.typicode.com/posts");
            List<Post> posts = objectMapper.readValue(src, new TypeReference<>() {
            });
            postRepository.saveAll(posts);
        };
    }
}