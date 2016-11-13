package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PokemonRepository {

    @Autowired
    private Map<String, String> database;

    @Value("${pokemon.default}")
    private String defaultPokemon;

    public String getPokemon(String userName) {
        return database.getOrDefault(userName, defaultPokemon);
    }
}
