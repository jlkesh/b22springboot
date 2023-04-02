package dev.jlkeesh.querycreation;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomersUnderAge(@RequestParam int age) {
        return customerRepository.findAllByAgeLessThan(age);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteCustomerUnderAge(@RequestParam int age) {
        customerRepository.deleteByAgeLessThan(age);
    }

    @GetMapping("/phone")
    public List<Customer> getCustomersByPhoneNumber(@RequestParam String phone) {
        return customerRepository.findAllByPhoneNumberStartingWith(phone);
    }

    @GetMapping("/class-projection")
    public List<CustomerDTO> classProjection(@RequestParam String phone) {
        return customerRepository.findAllByPhoneNumberEndingWith(phone);
    }

    @GetMapping("/interface-projection")
    public List<ICustomerDTO> interfaceProjection(@RequestParam int age) {
        return customerRepository.findAllByAgeGreaterThan(age);
    }

    @GetMapping("/customersInfo")
    public List<CustomerDTO> customersInfo() {
        return customerRepository.customersInfo();
    }

}
