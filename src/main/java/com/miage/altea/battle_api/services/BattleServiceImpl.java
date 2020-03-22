package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.*;
import com.miage.altea.battle_api.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class BattleServiceImpl implements BattleService {
    @Autowired
    public TrainerServiceImpl trainerService;

    @Autowired
    public BattleRepository battleRepository;

    public BattleServiceImpl(TrainerServiceImpl trainersService) {
        this.trainerService = trainersService;
    }
    @Override
    public void createBattle(String trainerName, String opponentName) {
        Trainer trainer = this.trainerService.getTrainer(trainerName);
        Trainer opponent = this.trainerService.getTrainer(opponentName);
        //BattleTrainer battleTrainer = new BattleTrainer(trainer, false, trainer.getTeam())
    }

    @Override
    public Collection<Battle> getAllBattles() {
        return this.battleRepository.findAllBattles();
    }

    @Override
    public Battle getBattle(UUID uuid) {
        return this.battleRepository.findBattleById(uuid);
    }

    @Override
    public Battle attack(UUID uuid, String trainerName) {
        return null;
    }

    @Override
    public Battle heal(UUID uuid, BattleObject object, BattlePokemon pokemon) {
        return null;
    }

    public BattleRepository getBattleRepository() {
        return battleRepository;
    }

    public void setBattleRepository(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }
}
