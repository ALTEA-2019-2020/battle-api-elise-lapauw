package com.miage.altea.battle_api.services;

import com.miage.altea.battle_api.bo.Pokemon.Pokemon;
import com.miage.altea.battle_api.bo.Pokemon.PokemonType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    String pokemonServiceUrl;
    RestTemplate restTemplate;

    public List<PokemonType> listPokemonsTypes() {
        var list = Arrays.asList(restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/", PokemonType[].class));
        return list != null ? list : new ArrayList<PokemonType>();
    }

    @Override
    public PokemonType getPokemon(int id) {
        return restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/{id}", PokemonType.class, id);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }

    public PokemonType convertPokemon(Pokemon pokemon) {
        return this.getPokemon(pokemon.getPokemonTypeId());
    }
}