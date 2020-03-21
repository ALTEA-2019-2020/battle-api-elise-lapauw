package com.miage.altea.battle_api.bo;

public class Battle {
    String uuid;
    BattleTrainer trainer;
    BattleTrainer opponent;

    public Battle(BattleTrainer trainer, BattleTrainer opponent) {
        this.trainer = trainer;
        this.opponent = opponent;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BattleTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(BattleTrainer trainer) {
        this.trainer = trainer;
    }

    public BattleTrainer getOpponent() {
        return opponent;
    }

    public void setOpponent(BattleTrainer opponent) {
        this.opponent = opponent;
    }
}
