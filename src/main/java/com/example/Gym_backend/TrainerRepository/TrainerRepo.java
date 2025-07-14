package com.example.Gym_backend.TrainerRepository;

import com.example.Gym_backend.Trainerentity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer,Long> {
}
