package com.example.camp.service;

import com.example.camp.dto.ActivityDTO;
import com.example.camp.dto.CreateSignUpDTO;
import com.example.camp.exception.NotFoundException;
import com.example.camp.exception.ValidationException;
import com.example.camp.model.Activity;
import com.example.camp.model.Signup;
import com.example.camp.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<ActivityDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(activity -> mapper.map(activity, ActivityDTO.class))
                .toList();
    }

    public void deleteById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new NotFoundException("Activity not found");
        }
    }

    public Optional<Activity> getActivityById(Long id) {
        return repository.findById(id);
    }
}