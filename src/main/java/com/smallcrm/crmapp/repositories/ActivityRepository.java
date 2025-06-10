package com.smallcrm.crmapp.repositories;

import com.smallcrm.crmapp.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}