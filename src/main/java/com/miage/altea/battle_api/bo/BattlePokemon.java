package com.miage.altea.battle_api.bo;

public class BattlePokemon {
    int currentHpLevel;
    int maxHp;
    PokemonType pokemonType;
    int level;
    boolean ko;

    public BattlePokemon(int currentHpLevel, int maxHp, PokemonType pokemonType, int level) {
        this.currentHpLevel = currentHpLevel;
        this.maxHp = maxHp;
        this.pokemonType = pokemonType;
        this.level = level;
        this.ko = false;
    }

    public int getCurrentHpLevel() {
        return currentHpLevel;
    }

    public void setCurrentHpLevel(int currentHpLevel) {
        this.currentHpLevel = currentHpLevel;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isKo() {
        return ko;
    }

    public void setKo(boolean ko) {
        this.ko = ko;
    }
}
