package com.cloudy.simplespring.dto;

import lombok.Data;

@Data
public class UpdateUserPasswordResponse {
    private Long id;

    public UpdateUserPasswordResponse(Long id) {
        this.id = id;
    }
}
