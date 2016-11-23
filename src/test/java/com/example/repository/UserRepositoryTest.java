package com.example.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnCorrectPokemon() {
        Assert.assertEquals("charmander", userRepository.getPokemon("chris"));
        Assert.assertEquals("abra", userRepository.getPokemon("lucy"));
    }

    @Test
    public void shouldReturnDefaultPokemon() {
        Assert.assertEquals("dragonite", userRepository.getPokemon("non-existing-user"));
    }
}
