package dev.jlkeesh;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppErrorDTO implements Serializable {
    private Object error;
    private String error_path;
    private Integer error_code;
    @Builder.Default
    private LocalDateTime timestamp= LocalDateTime.now();
}
