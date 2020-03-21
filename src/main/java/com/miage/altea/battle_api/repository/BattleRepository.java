package com.miage.altea.battle_api.repository;

import com.miage.altea.battle_api.bo.Battle;

import java.util.List;

public interface BattleRepository {
    Battle findBattleById(String uuid);
    List<Battle> findAllBattles();
    void addBattle(Battle battle);
}
