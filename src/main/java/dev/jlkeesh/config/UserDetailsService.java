package dev.jlkeesh.config;

import dev.jlkeesh.domains.AuthUser;
import dev.jlkeesh.dto.GenerateTokenDTO;
import dev.jlkeesh.repository.AuthUserRepository;
import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AuthUserRepository authUserRepository;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public UserDetailsService(AuthUserRepository authUserRepository,
                              JwtUtils jwtUtils,
                              @Lazy AuthenticationManager authenticationManager) {
        this.authUserRepository = authUserRepository;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new UserDetails(authUser);
    }

    public String generateToken(@NonNull GenerateTokenDTO dto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (!authenticate.isAuthenticated())
            throw new RuntimeException("Bad credentials");
        return jwtUtils.generateToken(Map.of(), loadUserByUsername(dto.username()).getAuthUser());
    }
}
