package com.miage.altea.battle_api.bo.Battle;

import com.miage.altea.battle_api.bo.Pokemon.PokemonType;
import com.miage.altea.battle_api.bo.Pokemon.Stats;
import com.miage.altea.battle_api.services.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class BattlePokemon {
    int currentHpLevel;
    int maxHp;
    PokemonType pokemonType;
    int level;
    boolean ko;
    int id;

    @Autowired
    private PokemonTypeService pokemonTypeService;

    public BattlePokemon(int currentHpLevel, int maxHp, PokemonType pokemonType, int level, int id) {
        this.currentHpLevel = currentHpLevel;
        this.maxHp = maxHp;
        this.pokemonType = pokemonType;
        this.level = level;
        this.id = id;
        this.ko = false;
        this.initStats(pokemonType);
    }


    public void initStats(PokemonType pokemonType) {
        Stats statsInit = pokemonType.getStats();
        Double coeff = Double.valueOf(this.level) / 50;
        Double attack = 5 + (pokemonType.getStats().getAttack()* coeff);
        statsInit.setAttack((int) Math.floor(attack));
        Double defense = 5 + (pokemonType.getStats().getDefense()* coeff);
        statsInit.setDefense((int) Math.floor(defense));
        Double hp = 5 + (pokemonType.getStats().getHp()* coeff);
        statsInit.setHp((int) Math.floor(hp));
        Double speed = 5 + (pokemonType.getStats().getSpeed()* coeff);
        statsInit.setSpeed((int) Math.floor(speed));
        this.pokemonType.setStats(statsInit);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
