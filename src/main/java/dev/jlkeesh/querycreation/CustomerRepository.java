package dev.jlkeesh.querycreation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByAgeLessThan(int age);

    void deleteByAgeLessThan(int age);


    @Query(nativeQuery = true, value = "select id, full_name, age from customer")
        /*@Query("select new dev.jlkeesh.querycreation.CustomerDTO(c.id, c.fullName) from Customer c")*/
    List<Object[]> customersInfo();

    List<Customer> findAllByPhoneNumberStartingWith(String phone);

    List<CustomerDTO> findAllByPhoneNumberEndingWith(String phone);


    List<ICustomerDTO> findAllByAgeGreaterThan(int age);

}