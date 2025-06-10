package com.smallcrm.crmapp.services;

import com.smallcrm.crmapp.models.CustomerActivity;
import com.smallcrm.crmapp.repositories.CustomerActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerActivityService {

    private final CustomerActivityRepository customerActivityRepo;

    public CustomerActivityService(CustomerActivityRepository customerActivityRepo) {
        this.customerActivityRepo = customerActivityRepo;
    }

    public List<CustomerActivity> getAllCustomerActivities() { // ✅ Fixed typo: "Activitys" → "Activities"
        return customerActivityRepo.findAll();
    }

    public Optional<CustomerActivity> getCustomerActivityById(Long id) {
        return customerActivityRepo.findById(id);
    }

    public CustomerActivity createCustomerActivity(CustomerActivity customerActivity) { // ✅ Param name lowercase
        return customerActivityRepo.save(customerActivity);
    }

    public Optional<CustomerActivity> updateCustomerActivity(Long id, CustomerActivity updated) {
        return customerActivityRepo.findById(id).map(existing -> {
            existing.setCustomer(updated.getCustomer());
            existing.setActivity(updated.getActivity());
            existing.setActivityDate(updated.getActivityDate());
            existing.setActivityNotes(updated.getActivityNotes());
            return customerActivityRepo.save(existing);
        });
    }

    public boolean deleteCustomerActivity(Long id) {
        if (!customerActivityRepo.existsById(id)) return false;
        customerActivityRepo.deleteById(id);
        return true;
    }
}
