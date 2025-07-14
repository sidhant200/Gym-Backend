package com.example.Gym_backend.Trainerdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TrainerDto {

    private String name;
    private String phone;
    private String email;

}
