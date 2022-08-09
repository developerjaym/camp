package com.example.camp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CreateSignUpDTO {
    @Min(0)
    @Max(23)
    private int time;
    @JsonProperty("camper_id")
    @Positive
    @NotNull
    private Long camperId;
    @JsonProperty("activity_id")
    @Positive
    @NotNull
    private Long activityId;
}