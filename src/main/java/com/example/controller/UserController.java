package com.example.controller;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository pokemonRepository;

    @GetMapping("/user/{userName}")
    public GetUserResponse getUser(@PathVariable("userName") String userName) {
        return GetUserResponse.of(userName, pokemonRepository.getPokemon(userName));
    }

    @PutMapping("/user/{userName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UpdateUserRequest request,
                           @PathVariable("userName") String userName) {
        if(request.pokemon == null || request.pokemon.trim().isEmpty()) {
            throw new IllegalArgumentException("pokemon field cannot be blank");
        }

        pokemonRepository.saveUser(userName, request.pokemon);
    }

    public static class UpdateUserRequest {
        public String pokemon;

        public static UpdateUserRequest of(String pokemon) {
            UpdateUserRequest request = new UpdateUserRequest();
            request.pokemon = pokemon;
            return request;
        }
    }

    public static class GetUserResponse {
        public String user, pokemon;

        public static GetUserResponse of(String user, String pokemon) {
            GetUserResponse response = new GetUserResponse();
            response.user = user;
            response.pokemon = pokemon;
            return response;
        }
    }
}
