package dev.jlkeesh.config;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SessionUser {

    public Long getId() {
        return new Random().nextLong(1, 20);
    }
}
