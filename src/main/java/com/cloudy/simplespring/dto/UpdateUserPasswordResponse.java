package com.cloudy.simplespring.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateUserPasswordResponse {
    private Long id;

    public UpdateUserPasswordResponse(Long id) {
        this.id = id;
    }
}
