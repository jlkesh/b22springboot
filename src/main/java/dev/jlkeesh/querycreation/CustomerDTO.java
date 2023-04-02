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
    private int age;

    public CustomerDTO(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
