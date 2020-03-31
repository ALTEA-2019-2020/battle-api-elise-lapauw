package com.miage.altea.battle_api.repository;

import com.miage.altea.battle_api.bo.Battle.Battle;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BattleRepositoryImpl implements BattleRepository {

    Map<UUID, Battle> battles = new HashMap<>();

    @Override
    public Battle findBattleById(UUID uuid) {
        return this.battles.get(uuid);
    }

    @Override
    public Collection<Battle> findAllBattles() {
        return this.battles != null ? this.battles.values() : new ArrayList<>();
    }

    @Override
    public void addBattle(Battle battle) {
        this.battles.put(battle.getUuid(), battle);
    }

    @Override
    public void saveBattle(Battle battle) {
        this.battles.replace(battle.getUuid(), battle);
    }
}
