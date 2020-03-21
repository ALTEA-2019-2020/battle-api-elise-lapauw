package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.bo.BattleTrainer;
import com.miage.altea.battle_api.bo.Trainer;
import com.miage.altea.battle_api.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Battle> getAllBattles() {
        return null;
    }

    @Override
    public Battle getBattle(String uuid) {
        return null;
    }

    @Override
    public Battle attack(String uuid, String trainerName) {
        return null;
    }

    public BattleRepository getBattleRepository() {
        return battleRepository;
    }

    public void setBattleRepository(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }
}
