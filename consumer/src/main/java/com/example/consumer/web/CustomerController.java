package com.example.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/customer-emails")
    public List<String> getCustomerEmails() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CustomerResponse> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("/customers", HttpMethod.GET, entity, CustomerResponse.class).getBody()
                .getCustomers()
                .stream()
                .map(CustomerResponse.Customer::getEmailAddress)
                .collect(Collectors.toList());
    }
}
