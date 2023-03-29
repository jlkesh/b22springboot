package dev.jlkeesh;

import dev.jlkeesh.config.UserDetails;
import dev.jlkeesh.config.UserDetailsService;
import dev.jlkeesh.dto.GenerateTokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserDetailsService userDetailsService;

    public AuthController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody GenerateTokenDTO dto) {
        return ResponseEntity.ok(userDetailsService.generateToken(dto));
    }
}
