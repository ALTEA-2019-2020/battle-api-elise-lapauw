package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.Battle.Battle;
import com.miage.altea.battle_api.bo.Battle.BattleObject;
import com.miage.altea.battle_api.bo.Battle.BattlePokemon;
import com.miage.altea.battle_api.bo.Battle.BattleTrainer;
import com.miage.altea.battle_api.bo.Pokemon.Pokemon;
import com.miage.altea.battle_api.bo.Pokemon.PokemonType;
import com.miage.altea.battle_api.bo.Pokemon.Trainer;
import com.miage.altea.battle_api.exceptions.ApiError;
import com.miage.altea.battle_api.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class BattleServiceImpl implements BattleService {

    @Autowired
    public TrainerService trainerService;

    @Autowired
    public PokemonTypeService pokemonTypeService;

    @Autowired
    public BattleRepository battleRepository;

    public TrainerService getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Override
    public Battle createBattle(String trainerName, String opponentName) {
        Trainer trainer = this.trainerService.getTrainer(trainerName);
        Trainer opponent = this.trainerService.getTrainer(opponentName);
        if (trainer == null || opponent == null) {
            throw new ApiError(HttpStatus.NOT_FOUND, "One of the trainer doesn't exist. Please check again");
        }
        BattleTrainer t = new BattleTrainer(trainer, false, new ArrayList<BattlePokemon>());
        initTeam(t);
        BattleTrainer o = new BattleTrainer(opponent, false, new ArrayList<BattlePokemon>());
        initTeam(o);
        var isPokemonTrainerFaster = // tells wich pokemon starts
                t.getBattlePokemonList().get(0).getPokemonType().getStats().getSpeed() >
                        o.getBattlePokemonList().get(0).getPokemonType().getStats().getSpeed();
        t.setNextTurn(isPokemonTrainerFaster);
        o.setNextTurn(!isPokemonTrainerFaster);
        Battle battle = new Battle(t,o);

        this.battleRepository.addBattle(battle);
        return battle;
    }

    private void initTeam(BattleTrainer trainer) {
        for (Pokemon p : trainer.getTrainer().getTeam()) {
            PokemonType pokemon = this.pokemonTypeService.getPokemon(p.getPokemonTypeId());
            BattlePokemon bp = new BattlePokemon(pokemon.getStats().getHp(), pokemon.getStats().getHp(),
                    pokemon , p.getLevel(), p.getPokemonTypeId());
            trainer.getBattlePokemonList().add(bp);
        }
    }

    @Override
    public Collection<Battle> getAllBattles() {
        return this.battleRepository.findAllBattles();
    }

    @Override
    public Battle getBattle(UUID uuid) {
        Battle battle = this.battleRepository.findBattleById(uuid);
        if (battle == null) {
            throw new ApiError(HttpStatus.NOT_FOUND, "This battle doesn't exist");
        }
        return battle;
    }

    @Override
    public Battle attack(UUID uuid, String trainerName) {
        Battle battle = getBattle(uuid);
        getattacker(uuid, trainerName);
        if (isFightOver(battle)) {
            BattleTrainer winner = battle.getTrainer().getNextPokemon() != null ? battle.getTrainer() : battle.getOpponent();
            battle.setWinner(winner);
        }
        return battle;
    }

    @Override
    public Battle heal(UUID uuid, BattleObject object, BattlePokemon pokemon) {
        return null;
    }

    public BattleRepository getBattleRepository() {
        return battleRepository;
    }

    public void setBattleRepository(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    private void getattacker(UUID uuid, String trainerName) {
        Battle battle = this.getBattle(uuid);
        if (trainerName.equals(battle.getTrainer().getTrainer().getName())) {
            if (battle.getTrainer().isNextTurn()) {
                attackOnce(battle.getTrainer(), battle.getOpponent());
            } else {
                throw new ApiError(HttpStatus.BAD_REQUEST, "It's the opponent's turn to attack !");
            }
        } else {
            if (trainerName.equals(battle.getOpponent().getTrainer().getName())) {
                if (battle.getOpponent().isNextTurn()) {
                    attackOnce(battle.getOpponent(), battle.getTrainer());
                } else {
                    throw new ApiError(HttpStatus.BAD_REQUEST, "It's your turn to attack !");
                }
            }
        }
    }

    private void attackOnce(BattleTrainer trainer, BattleTrainer opponent) {
        Optional<BattlePokemon> pokemonTrainer = trainer.getNextPokemon();
        Optional<BattlePokemon> pokemonOpponent = opponent.getNextPokemon();
        Double coeffLevel = Double.valueOf(pokemonTrainer.get().getLevel())/5;
        Double coeffAttack = Double.valueOf(
                pokemonTrainer.get().getPokemonType().getStats().getAttack()/
                        pokemonOpponent.get().getPokemonType().getStats().getDefense());
        int currentHp = pokemonOpponent.get().getCurrentHpLevel();
        int damage = (int) Math.floor((2*coeffLevel + 2*coeffAttack)+2);
        pokemonOpponent.get().setCurrentHpLevel(currentHp - damage);
        checkIfPokemonIsKo(pokemonOpponent);
        trainer.setNextTurn(false);
        opponent.setNextTurn(true);
    }

    private void checkIfPokemonIsKo(Optional<BattlePokemon> pokemon) {
        pokemon.get().setKo(pokemon.get().getCurrentHpLevel() < 0);
    }

    private boolean isFightOver(Battle battle) {
        return battle.getTrainer().getNextPokemon() == null || battle.getOpponent().getNextPokemon() == null;
    }
}
