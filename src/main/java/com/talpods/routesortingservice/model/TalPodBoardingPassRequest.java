package com.talpods.routesortingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class TalPodBoardingPassRequest {
    private String from;
    private String to;
    private String seat;
    private String transportType;
}
