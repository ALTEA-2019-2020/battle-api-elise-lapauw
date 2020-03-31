package com.miage.altea.battle_api.bo.Battle;

import java.util.UUID;

public class Battle {
    UUID uuid;
    BattleTrainer trainer;
    BattleTrainer opponent;
    BattleTrainer winner;

    public Battle(BattleTrainer trainer, BattleTrainer opponent) {
        this.uuid = UUID.randomUUID();
        this.trainer = trainer;
        this.opponent = opponent;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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

    public BattleTrainer getWinner() {
        return winner;
    }

    public void setWinner(BattleTrainer winner) {
        this.winner = winner;
    }
}
