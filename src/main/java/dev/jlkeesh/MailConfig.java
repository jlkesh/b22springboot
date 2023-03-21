package dev.jlkeesh;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ConfigurationProperties(prefix = "mail")
public class MailConfig {
    private String server;
    private String user;
    private String password;
}
