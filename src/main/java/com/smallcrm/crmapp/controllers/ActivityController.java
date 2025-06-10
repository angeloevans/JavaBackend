package com.smallcrm.crmapp.controllers;

import com.smallcrm.crmapp.models.Activity;
import com.smallcrm.crmapp.repositories.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")  
public class ActivityController {
    private final ActivityRepository activityRepo;  

    public ActivityController(ActivityRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    // Get all activities
    @GetMapping
    public List<Activity> getAll() {
        return activityRepo.findAll();
    }

    // Get activity by id
    @GetMapping("/{id}")
    public ResponseEntity<Activity> getById(@PathVariable Long id) {
        Optional<Activity> activity = activityRepo.findById(id);
        return activity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());  
    }

    // Create new activity
    @PostMapping
    public ResponseEntity<Activity> create(@RequestBody Activity activity) {
        Activity savedActivity = activityRepo.save(activity);
        return new ResponseEntity<>(savedActivity, HttpStatus.CREATED);
    }

    // Update existing activity
    @PutMapping("/{id}")
    public ResponseEntity<Activity> update(@PathVariable Long id, @RequestBody Activity activityDetails) {
        Optional<Activity> existingActivity = activityRepo.findById(id);
        if (!existingActivity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Activity activity = existingActivity.get();
        activity.setActivity(activityDetails.getActivity());

        Activity updatedActivity = activityRepo.save(activity);
        return ResponseEntity.ok(updatedActivity);
    }

    // Delete activity by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!activityRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        activityRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}