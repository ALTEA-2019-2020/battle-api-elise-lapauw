package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.bo.BattleObject;
import com.miage.altea.battle_api.bo.BattlePokemon;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface BattleService {
    void createBattle(String trainerName, String opponentName);
    Collection<Battle> getAllBattles();
    Battle getBattle(UUID uuid);
    Battle attack(UUID uuid, String trainerName);
    Battle heal(UUID uuid, BattleObject object, BattlePokemon pokemon);
}
