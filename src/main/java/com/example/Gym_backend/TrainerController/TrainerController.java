package com.example.Gym_backend.TrainerController;

import com.example.Gym_backend.TrainerService.TrainerService;
import com.example.Gym_backend.Trainerdto.TrainerDto;
import com.example.Gym_backend.Trainerdto.TrainerDtoForid;
import com.example.Gym_backend.Trainerentity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("trainer")
    public List<TrainerDtoForid> getAllTrainers(){

        return trainerService.readAllTrainers();
    }

    @PostMapping("trainer")
    public ResponseEntity<TrainerDto> createTrainer(@RequestBody TrainerDto trainerDto){
      TrainerDto created =   trainerService.createTrainer(trainerDto);
        return ResponseEntity.ok(created);
    }

}
