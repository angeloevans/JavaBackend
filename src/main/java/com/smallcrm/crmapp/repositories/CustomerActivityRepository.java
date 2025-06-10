package com.smallcrm.crmapp.repositories;

import com.smallcrm.crmapp.models.CustomerActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerActivityRepository extends JpaRepository<CustomerActivity, Long> {
}