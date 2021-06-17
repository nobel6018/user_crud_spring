package com.cloudy.simplespring.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DeleteUserResponse {
    private String result;

    public DeleteUserResponse(String result) {
        this.result = result;
    }
}
