package dev.jlkeesh.querycreation;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer  {
    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;
    private int age;
    private String phoneNumber;

}
