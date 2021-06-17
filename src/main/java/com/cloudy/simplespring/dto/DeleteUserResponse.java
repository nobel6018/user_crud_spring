package com.cloudy.simplespring.dto;

import lombok.Data;

@Data
public class DeleteUserResponse {
    private String result;

    public DeleteUserResponse(String result) {
        this.result = result;
    }
}
