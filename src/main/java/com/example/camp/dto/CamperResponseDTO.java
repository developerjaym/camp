package com.example.camp.dto;

import lombok.Data;

import java.util.List;

@Data
public class CamperResponseDTO {
    private Long id;
    private String name;
    private int age;
    private List<ActivityDTO> activities;
}
