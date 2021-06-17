package com.cloudy.simplespring.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateUserRequest {
    @NotEmpty
    private String id;

    @NotEmpty
    private String password;
}
