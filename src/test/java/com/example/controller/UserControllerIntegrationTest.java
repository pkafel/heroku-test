package com.example.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldCreateUserWithPokemon() {
        // check user pokemon
        UserController.GetUserResponse response1 = this.restTemplate.getForObject("/user/chris", UserController.GetUserResponse.class);
        Assert.assertEquals("charmander", response1.pokemon);
        Assert.assertEquals("chris", response1.user);

        // update user pokemon
        UserController.UpdateUserRequest request = UserController.UpdateUserRequest.of("abra");
        this.restTemplate.put("/user/chris", request);

        // check if user's pokemon was updated
        UserController.GetUserResponse response2 = this.restTemplate.getForObject("/user/chris", UserController.GetUserResponse.class);
        Assert.assertEquals("abra", response2.pokemon);
        Assert.assertEquals("chris", response2.user);
    }

    @Test
    public void shouldReceive400WhenMissingPokemonNameOnUpdate() {
        UserController.UpdateUserRequest request = UserController.UpdateUserRequest.of(null);
        HttpEntity<UserController.UpdateUserRequest> httpEntity = new HttpEntity<>(request);

        ResponseEntity<Void> response = this.restTemplate.exchange("/user/chris", HttpMethod.PUT, httpEntity, Void.class);
        Assert.assertEquals(400, response.getStatusCodeValue());
    }
}
