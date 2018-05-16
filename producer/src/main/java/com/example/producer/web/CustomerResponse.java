package com.example.producer.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    public List<Customer> customers;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Customer {

        private String firstName;

        private String lastName;

        private String emailAddress;
    }
}
