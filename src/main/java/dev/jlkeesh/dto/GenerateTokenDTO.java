package dev.jlkeesh.dto;

import org.springdoc.core.annotations.ParameterObject;

import javax.swing.*;

@ParameterObject
public record GenerateTokenDTO(String username, String password) {
}
