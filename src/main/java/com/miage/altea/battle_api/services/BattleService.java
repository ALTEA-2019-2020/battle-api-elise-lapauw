package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.Battle;

import java.util.List;

public interface BattleService {
    void createBattle(String trainerName, String opoonentName);
    List<Battle> getAllBattles();
    Battle getBattle(String uuid);
    Battle attack(String uuid, String trainerName);
}
