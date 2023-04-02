package dev.jlkeesh.querycreation;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

/*@SqlResultSetMapping(
        name = "toCustomerDTO",
        classes = @ConstructorResult(
                targetClass = CustomerDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "full_name", type = String.class)
                }
        )
)
@NamedNativeQuery(
        name = "customersInfo",
        query = "select id, full_name from customer",
        resultSetMapping = "toCustomerDTO"
)*/
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;
    private int age;
    private String phoneNumber;

}
