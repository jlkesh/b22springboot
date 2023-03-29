package dev.jlkeesh;


import dev.jlkeesh.domains.AuthUser;
import dev.jlkeesh.repository.AuthUserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition
@SecurityScheme(name = "Auth", scheme = "Bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
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