package com.example.producer.web;

import com.example.producer.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public CustomerResponse getCustomers() {
        List<CustomerResponse.Customer> customers = customerRepository.findAll()
                .stream()
                .map(customerEntity -> new CustomerResponse.Customer(
                        customerEntity.getFirstName(),
                        customerEntity.getLastName(),
                        customerEntity.getEmailAddress()
                ))
                .collect(Collectors.toList());
        return new CustomerResponse(customers);
    }
}
