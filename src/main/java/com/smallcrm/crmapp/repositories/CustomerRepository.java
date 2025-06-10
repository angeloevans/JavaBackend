package com.smallcrm.crmapp.repositories;

import com.smallcrm.crmapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}