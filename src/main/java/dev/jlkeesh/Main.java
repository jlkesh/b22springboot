package dev.jlkeesh;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@OpenAPIDefinition(
        info = @Info(
                title = "Spring 6 Swagger With Annotation Config",
                version = "${api.version}",
                contact = @Contact(
                        name = "Elmurodov Javohir",
                        email = "john.lgd65@gmail.com",
                        url = "https://github.com/jlkesh"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"
                ),
                termsOfService = "http://swagger.io/terms/",
                description = "SFGate Scraper extracts data from sfgate.com. It uses a smart algorithm to decide what paged are articles and automatically extracts rich information about each article. It can scrape the entire website with one click.\n" +
                        "\n" +
                        "This free SFGate API will let you scrape and extract large datasets as often as you need to. The structured data can be downloaded as XML, JSON, CSV, HTML, and Excel, so that you can use it in your own applications, spreadsheets, reports, or other tools"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation",
                url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                ),
                @Server(
                        url = "http://localhost:8090",
                        description = "QA-Server"
                )
        }
)*/
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}