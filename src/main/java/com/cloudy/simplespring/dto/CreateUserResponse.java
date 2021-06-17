package com.cloudy.simplespring.dto;

import lombok.Data;

@Data
public class CreateUserResponse {
    private Long id;

    public CreateUserResponse(Long id) {
        this.id = id;
    }
}
