package com.mysite.quizApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HealthCheckDto {

    private boolean status;
    private String message;

}
