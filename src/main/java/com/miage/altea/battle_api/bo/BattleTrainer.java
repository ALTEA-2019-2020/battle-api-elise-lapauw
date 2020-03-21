package com.miage.altea.battle_api.bo;

import java.util.List;

public class BattleTrainer {
    Trainer trainer;
    boolean nextTurn;
    List<BattlePokemon> battlePokemonList;

    public BattleTrainer(Trainer trainer, boolean nextTurn, List<BattlePokemon> battlePokemonList) {
        this.trainer = trainer;
        this.nextTurn = nextTurn;
        this.battlePokemonList = battlePokemonList;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public boolean isNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(boolean nextTurn) {
        this.nextTurn = nextTurn;
    }

    public List<BattlePokemon> getBattlePokemonList() {
        return battlePokemonList;
    }

    public void setBattlePokemonList(List<BattlePokemon> battlePokemonList) {
        this.battlePokemonList = battlePokemonList;
    }
}
