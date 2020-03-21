package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> getAllTrainers();
    Trainer getTrainer(String name);
}