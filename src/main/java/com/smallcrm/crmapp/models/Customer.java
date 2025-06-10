package com.smallcrm.crmapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;
import java.util.List;

@Entity
@Table(name = "customers") 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private String lead = "YES";

    @NotBlank(message = "Name is required")
    private String customerName;

    @NotBlank(message = "Telephone is required")
    private String customerTelephone;

    @Email(message = "Email should be valid")
    private String customerEmail;

    private String customerAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerActivity> customerActivities;
}

