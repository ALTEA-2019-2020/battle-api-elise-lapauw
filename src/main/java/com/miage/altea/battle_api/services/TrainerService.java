package com.miage.altea.battle_api.services;


import com.miage.altea.battle_api.bo.Pokemon.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> getAllTrainers();
    Trainer getTrainer(String name);
    // Trainer createTrainer(Trainer trainer);
    // void deleteTrainer(String name);
}