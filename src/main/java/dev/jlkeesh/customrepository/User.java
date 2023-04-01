
package dev.jlkeesh.customrepository;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String username;
    private String website;

}
