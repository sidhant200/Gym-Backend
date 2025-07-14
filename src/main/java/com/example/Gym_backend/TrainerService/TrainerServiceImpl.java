package com.example.Gym_backend.TrainerService;

import com.example.Gym_backend.TrainerRepository.TrainerRepo;
import com.example.Gym_backend.Trainerdto.TrainerDto;
import com.example.Gym_backend.Trainerdto.TrainerDtoForid;
import com.example.Gym_backend.Trainerentity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service

public class TrainerServiceImpl implements TrainerService{
    @Autowired
    private TrainerRepo trainerRepo;

    @Override
    public List<TrainerDtoForid> readAllTrainers() {
        List<Trainer> trainers = trainerRepo.findAll();
       return trainers.stream()
                .map(this::convertToDtoForId)
                .collect(Collectors.toList());

    }

    @Override
    public boolean deleteTrainer(long id) {
        trainerRepo.deleteById(id);
        return true;
    }

    @Override
    public TrainerDto createTrainer(TrainerDto trainerDto) {
       Trainer trainer = new Trainer();
       trainer.setName(trainerDto.getName());
       trainer.setPhone(trainerDto.getPhone());
       trainer.setEmail(trainerDto.getEmail());

       Trainer saved = trainerRepo.save(trainer);
       return new TrainerDto(saved.getName(), saved.getPhone(), saved.getEmail());
    }



    @Override
    public TrainerDtoForid updateTrainer(Long id, TrainerDtoForid trainerDtoForid) {
        Trainer existesTrainer = trainerRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("id not existed" + id));
        existesTrainer.setName(trainerDtoForid.getName());
        existesTrainer.setPhone(trainerDtoForid.getPhone());
        existesTrainer.setEmail(trainerDtoForid.getEmail());
        Trainer updated = trainerRepo.save(existesTrainer);
        return convertToDtoForId(existesTrainer);

    }

    private TrainerDto convertToDto(Trainer trainer){
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setName(trainerDto.getName());
        trainerDto.setPhone(trainerDto.getPhone());
        trainerDto.setEmail(trainerDto.getEmail());
        return trainerDto;

    }
    private TrainerDtoForid convertToDtoForId(Trainer trainer){
        TrainerDtoForid trainerDtoForid = new TrainerDtoForid();
        trainerDtoForid.setId(trainer.getId());
        trainerDtoForid.setName(trainer.getName());
        trainerDtoForid.setPhone(trainer.getPhone());
        trainerDtoForid.setEmail(trainer.getEmail());
        return trainerDtoForid;
    }

}
