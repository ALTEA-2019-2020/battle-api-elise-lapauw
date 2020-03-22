package com.miage.altea.battle_api.repository;

import com.miage.altea.battle_api.bo.Battle;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface BattleRepository {
    Battle findBattleById(UUID uuid);
    Collection<Battle> findAllBattles();
    void addBattle(Battle battle);
    void saveBattle(Battle battle);
}
