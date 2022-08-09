package com.example.camp.service;

import com.example.camp.dto.ActivityDTO;
import com.example.camp.dto.CreateSignUpDTO;
import com.example.camp.exception.ValidationException;
import com.example.camp.model.Signup;
import com.example.camp.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupService {
    @Autowired
    private SignupRepository repository;

    @Autowired
    private CamperService camperService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ModelMapper modelMapper;

    public ActivityDTO create(CreateSignUpDTO createSignUpDTO) {
        Signup signup = new Signup();
        signup.setTime(createSignUpDTO.getTime());
        signup.setCamper(camperService.getCamperById(createSignUpDTO.getCamperId()).orElseThrow(() -> new ValidationException()));
        signup.setActivity(activityService.getActivityById(createSignUpDTO.getActivityId()).orElseThrow(() -> new ValidationException()));
        signup = repository.save(signup);
        return modelMapper.map(signup.getActivity(), ActivityDTO.class);
    }

    public List<ActivityDTO> getActivitiesByCamperId(Long camperId) {
        List<Signup> signupsForCamper = repository.findAllByCamperId(camperId);
        return signupsForCamper.stream()
                .map(signup -> signup.getActivity())
                .map(activity -> modelMapper.map(activity,
                    ActivityDTO.class))
                .toList();
    }
}
