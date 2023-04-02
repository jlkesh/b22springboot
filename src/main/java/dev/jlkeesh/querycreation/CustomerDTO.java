package dev.jlkeesh.querycreation;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO {
    private Integer id;
    private String fullName;
}
