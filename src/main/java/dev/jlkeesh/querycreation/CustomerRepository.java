package dev.jlkeesh.querycreation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByAgeLessThan(int age);

    void deleteByAgeLessThan(int age);

    List<Customer> findAllByPhoneNumberStartingWith(String phone);

    @Query("select c.id, c.fullName from Customer c")
    List<CustomerDTO> findAllClassProjection();

}