package com.miage.altea.battle_api.controller;

import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.services.BattleServiceImpl;
import com.miage.altea.battle_api.services.PokemonTypeService;
import com.miage.altea.battle_api.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/battles")
public class BattleController {
    @Autowired
    private final TrainerService trainerService;
    @Autowired
    private final PokemonTypeService pokemonTypeService;
    @Autowired
    private final BattleServiceImpl battleService;

    public BattleController(TrainerService trainerService, PokemonTypeService pokemonTypeService, BattleServiceImpl battleService){
        this.trainerService = trainerService;
        this.pokemonTypeService = pokemonTypeService;
        this.battleService = battleService;
    }

    @GetMapping()
    public List<Battle> getAllBattles() {
        return this.battleService.getAllBattles();
    }

    @PostMapping()
    public void createBattle(@RequestBody Map<String, String> body) {
        String trainerName = body.get("trainerName");
        String opponentName = body.get("opponentName");
        this.battleService.createBattle(trainerName, opponentName);

    }
    @GetMapping(value = "/{uuid}")
    public Battle getBattle(@PathVariable(value = "uuid")String uuid){
        return this.battleService.getBattle(uuid);
    }

    @PostMapping(value = "/{uuid}/{trainerName}/attack")
    public Battle attack(@PathVariable(value = "uuid") String uuid, @PathVariable(value = "trainerName") String trainerName){
        return this.battleService.attack(uuid, trainerName);
    }

}
