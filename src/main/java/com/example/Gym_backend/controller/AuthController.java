package com.example.Gym_backend.controller;


import com.example.Gym_backend.authDto.AuthRequestDto;
import com.example.Gym_backend.authDto.AuthResponseDto;
import com.example.Gym_backend.service.Jwtservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final Jwtservice jwtservice;

    public AuthController(Jwtservice jwtservice) {

        this.jwtservice = jwtservice;
    }
        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody AuthRequestDto request){

        if (request.getUsername().equals("admin") && request.getPassword().equals("admin123")){
            String token = jwtservice.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponseDto(token));


        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
