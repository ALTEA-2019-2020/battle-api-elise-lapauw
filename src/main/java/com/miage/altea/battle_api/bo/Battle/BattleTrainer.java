package com.miage.altea.battle_api.bo.Battle;

import com.miage.altea.battle_api.bo.Pokemon.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BattleTrainer {
    Trainer trainer;
    boolean nextTurn;
    ArrayList<BattlePokemon> battlePokemonList;
    //List<BattleObject> battleObjectList;

    public BattleTrainer(Trainer trainer, boolean nextTurn, ArrayList<BattlePokemon> battlePokemonList) {
        this.trainer = trainer;
        this.nextTurn = nextTurn;
        this.battlePokemonList = battlePokemonList;
        //this.battleObjectList = battleObjectList;
    }
    public Optional<BattlePokemon> getNextPokemon() {
        return battlePokemonList.stream().filter(pokemon -> !pokemon.isKo()).findFirst();
    }
/*public List<BattleObject> getBattleObjectList() {
        return battleObjectList;
    }

    public void setBattleObjectList(List<BattleObject> battleObjectList) {
        this.battleObjectList = battleObjectList;
    }*/

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

    public void setBattlePokemonList(ArrayList<BattlePokemon> battlePokemonList) {
        this.battlePokemonList = battlePokemonList;
    }
}
