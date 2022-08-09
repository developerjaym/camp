package com.example.camp.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateCamperDTO {
    @NotBlank
    private String name;
    @Max(18)
    @Min(8)
    private int age;
}
