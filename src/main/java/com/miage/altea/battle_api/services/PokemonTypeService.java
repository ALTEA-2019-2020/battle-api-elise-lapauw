package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.PokemonType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface PokemonTypeService {
    List<PokemonType> listPokemonsTypes();
    PokemonType getPokemon(int id);
    void setRestTemplate(RestTemplate restTemplate);
    void setPokemonTypeServiceUrl(String pokemonServiceUrl);
}
