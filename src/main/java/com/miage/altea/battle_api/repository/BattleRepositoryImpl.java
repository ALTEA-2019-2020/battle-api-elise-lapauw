package com.miage.altea.battle_api.repository;

import com.miage.altea.battle_api.bo.Battle;

import java.util.*;

public class BattleRepositoryImpl implements BattleRepository {

    Map<UUID, Battle> battles;

    @Override
    public Battle findBattleById(UUID uuid) {
        return this.battles.get(uuid);
    }

    @Override
    public Collection<Battle> findAllBattles() {
        return this.battles.values();
    }

    @Override
    public void addBattle(Battle battle) {
        UUID uuid = UUID.randomUUID();
        this.battles.put(uuid, battle);
    }

    @Override
    public void saveBattle(Battle battle) {
        this.battles.replace(battle.getUuid(), battle);
    }
}
