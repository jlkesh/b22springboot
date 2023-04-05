package dev.jlkeesh.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring 6 Swagger 2 Annotation Example")
                        .description("Spring 6 Swagger Simple Application")
                        .version("${api.version}")
                        .contact(new Contact()
                                .name("Elmurodov Javohir")
                                .email("john.lgd65@gmail.com")
                                .url("https://github.com/jlkesh"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Production-Server"),
                        new Server().url("http://localhost:9090").description("Test-Server")
                ))
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearerAuth")
                        .addList("basicAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("bearerAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT"))
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .name("basicAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic"))
                );

    }

    @Bean
    public GroupedOpenApi annotationGroupAPI() {
        return GroupedOpenApi.builder()
                .group("annotation")
                .pathsToMatch("/api/posts/**", "/config/**")
                .build();
    }
}

