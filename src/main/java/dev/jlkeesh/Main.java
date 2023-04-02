package dev.jlkeesh;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jlkeesh.config.SessionUser;
import dev.jlkeesh.customrepository.User;
import dev.jlkeesh.customrepository.UserRepo;
import dev.jlkeesh.jparepository.PostRepository;
import dev.jlkeesh.querycreation.Customer;
import dev.jlkeesh.querycreation.CustomerRepository;
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
    private final CustomerRepository customerRepository;

    public Main(
            PostRepository postRepository,
            ObjectMapper objectMapper,
            UserRepo userRepository, SessionUser sessionUser,
            CustomerRepository customerRepository) {
        this.postRepository = postRepository;
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
        this.sessionUser = sessionUser;
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    /*@Bean*/
    CommandLineRunner runner() {

     return args -> {
         Customer customer = Customer.builder()
                 .fullName("Abdullo Xayrullayev")
                 .phoneNumber("93 477 55 71")
                 .age(23)
                 .build();
         Customer azmiddin = Customer.builder()
                 .fullName("Abdullayev Azmiddin")
                 .phoneNumber("90 711 36 91")
                 .age(18)
                 .build();

         Customer nodira = Customer.builder()
                 .fullName("Shorahmedova Nodira")
                 .phoneNumber("90 711 12 90")
                 .age(20)
                 .build();
         customerRepository.save(customer);
         customerRepository.save(azmiddin);
         customerRepository.save(nodira);
         /*
            URL src = new URL("https://jsonplaceholder.typicode.com/users");
            List<User> users = objectMapper.readValue(src, new TypeReference<>() {
            });
            userRepository.saveAll(users);
            */

        };
    }


    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(sessionUser.getId());
    }
}