package com.example.Gym_backend.TrainerService;

import com.example.Gym_backend.Trainerdto.TrainerDto;
import com.example.Gym_backend.Trainerdto.TrainerDtoForid;
import com.example.Gym_backend.Trainerentity.Trainer;

import java.util.List;

public interface TrainerService {
    List<TrainerDtoForid> readAllTrainers();
    boolean deleteTrainer(long id);
    TrainerDto createTrainer(TrainerDto trainerDto);
    TrainerDtoForid updateTrainer(Long id , TrainerDtoForid trainerDtoForid );
}
