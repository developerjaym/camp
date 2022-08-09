package com.example.camp.controller;

import com.example.camp.dto.ActivityDTO;
import com.example.camp.dto.CreateSignUpDTO;
import com.example.camp.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("signups")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @PostMapping
    public ActivityDTO createSignup(@Valid @RequestBody CreateSignUpDTO createSignUpDTO) {
        return signupService.create(createSignUpDTO);
    }
}
