package com.smallcrm.crmapp.services;

import com.smallcrm.crmapp.models.Activity;
import com.smallcrm.crmapp.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepo;

    public ActivityService(ActivityRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    public List<Activity> getAllActivities() {
        return activityRepo.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return activityRepo.findById(id);
    }

    public Activity createActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    public Optional<Activity> updateActivity(Long id, Activity updatedData) {
        return activityRepo.findById(id).map(activity -> {
            activity.setActivity(updatedData.getActivity());
            return activityRepo.save(activity);
        });
    }

    public boolean deleteActivity(Long id) {
        if (!activityRepo.existsById(id)) return false;
        activityRepo.deleteById(id);
        return true;
    }
}
