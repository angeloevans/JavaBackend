package com.smallcrm.crmapp.controllers;

import com.smallcrm.crmapp.models.CustomerActivity;
import com.smallcrm.crmapp.repositories.CustomerActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/customeractivities")
public class CustomerActivityController {
    private final CustomerActivityRepository customerActivityRepo;

    public CustomerActivityController(CustomerActivityRepository customerActivityRepo) {
        this.customerActivityRepo = customerActivityRepo;
    }

    // Get all Customer Activities
    @GetMapping
    public List<CustomerActivity> getAll() {
        return customerActivityRepo.findAll();
    }

    // Get Customer Activity by id
    @GetMapping("/{id}")
    public ResponseEntity<CustomerActivity> getById(@PathVariable Long id) {
        Optional<CustomerActivity> customerActivity = customerActivityRepo.findById(id);
        return customerActivity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create New Customer Activity
    @PostMapping
    public ResponseEntity<CustomerActivity> create(@RequestBody CustomerActivity customerActivity) {
        CustomerActivity saved = customerActivityRepo.save(customerActivity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Update existing Customer Activity
    @PutMapping("/{id}")
    public ResponseEntity<CustomerActivity> update(@PathVariable Long id, @RequestBody CustomerActivity updatedData) {
        Optional<CustomerActivity> optionalExisting = customerActivityRepo.findById(id);
        if (!optionalExisting.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        CustomerActivity existing = optionalExisting.get();
        existing.setActivityDate(updatedData.getActivityDate());
        existing.setActivityNotes(updatedData.getActivityNotes());
        existing.setActivity(updatedData.getActivity());
        existing.setCustomer(updatedData.getCustomer());

        CustomerActivity updated = customerActivityRepo.save(existing);
        return ResponseEntity.ok(updated);
    }

    // Delete Customer Activity by id
    @DeleteMapping("/{id}") // <-- fixed this (you had no {id} in the path)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!customerActivityRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        customerActivityRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}