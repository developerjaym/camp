package com.example.camp.controller;

import com.example.camp.dto.ActivityDTO;
import com.example.camp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<ActivityDTO> getAllActivities() {
        return activityService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteActivityById(@PathVariable Long id) {
        activityService.deleteById(id);
    }

}
