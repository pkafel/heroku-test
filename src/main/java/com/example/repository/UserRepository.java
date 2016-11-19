package com.example.repository;

import com.example.config.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private BaseConfig.PokemonProperties pokemonProperties;

    public String getPokemon(String userName) {
        return pokemonProperties.getInit().getOrDefault(userName, pokemonProperties.getDefaultPokemon());
    }

    public void saveUser(String userName, String pokemon) {
        pokemonProperties.getInit().put(userName, pokemon);
    }
}
