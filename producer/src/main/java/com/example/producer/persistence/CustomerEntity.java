package com.example.producer.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue
    Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String emailAddress;
}
