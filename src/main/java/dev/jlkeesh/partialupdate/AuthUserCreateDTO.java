package dev.jlkeesh.partialupdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserCreateDTO {
    private String id;
    private String username;
    private String email;
    private String role;
}
