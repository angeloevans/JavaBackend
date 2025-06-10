package com.smallcrm.crmapp.services;

import com.smallcrm.crmapp.models.Customer;
import com.smallcrm.crmapp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Optional<Customer> updateCustomer(Long id, Customer updatedData) {
        return customerRepo.findById(id).map(customer -> {
            customer.setLead(updatedData.getLead());
            customer.setCustomerName(updatedData.getCustomerName());
            customer.setCustomerTelephone(updatedData.getCustomerTelephone());
            customer.setCustomerEmail(updatedData.getCustomerEmail());
            customer.setCustomerAddress(updatedData.getCustomerAddress());
            return customerRepo.save(customer);
        });
    }

    public boolean deleteCustomer(Long id) {
        if (!customerRepo.existsById(id)) return false;
        customerRepo.deleteById(id);
        return true;
    }
}