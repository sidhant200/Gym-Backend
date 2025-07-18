package com.example.Gym_backend.authDto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String token;
    public AuthResponseDto(String token) {
        this.token = token;
    }
}
