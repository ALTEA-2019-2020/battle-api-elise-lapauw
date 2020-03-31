package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.Battle.Battle;
import com.miage.altea.battle_api.bo.Battle.BattleObject;
import com.miage.altea.battle_api.bo.Battle.BattlePokemon;

import java.util.Collection;
import java.util.UUID;

public interface BattleService {
    Battle createBattle(String trainerName, String opponentName);
    Collection<Battle> getAllBattles();
    Battle getBattle(UUID uuid);
    Battle attack(UUID uuid, String trainerName) throws Exception;
    Battle heal(UUID uuid, BattleObject object, BattlePokemon pokemon);
}
