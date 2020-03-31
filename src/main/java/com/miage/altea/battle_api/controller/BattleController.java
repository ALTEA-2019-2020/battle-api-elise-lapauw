package com.miage.altea.battle_api.controller;

import com.miage.altea.battle_api.bo.Battle.Battle;
import com.miage.altea.battle_api.services.BattleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/battles")
public class BattleController {

    @Autowired
    private final BattleServiceImpl battleService;

    public BattleController(BattleServiceImpl battleService){
        this.battleService = battleService;
    }

    @GetMapping()
    public Collection<Battle> getAllBattles() {
        return this.battleService.getAllBattles();
    }


    @PostMapping()
    public Battle battles(@RequestParam(value = "trainer")String trainerName,
                                     @RequestParam(value = "opponent")String opponentName) {
        return this.battleService.createBattle(trainerName, opponentName);
    }

    @GetMapping(value = "/{uuid}")
    public Battle getBattle(@PathVariable(value = "uuid")UUID uuid){
        return this.battleService.getBattle(uuid);
    }

    @PostMapping(value = "/{uuid}/{trainerName}/attack")
    public Battle attack(@PathVariable(value = "uuid") UUID uuid, @PathVariable(value = "trainerName") String trainerName){
        return this.battleService.attack(uuid, trainerName);
    }

}
