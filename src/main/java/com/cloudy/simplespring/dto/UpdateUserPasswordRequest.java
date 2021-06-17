package com.cloudy.simplespring.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateUserPasswordRequest {
    @NotEmpty
    private String password;
}
