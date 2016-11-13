# Open Tech School Spring Boot workshops 

## Exercise 1

* In `src/main/java/resources` create configuration file (`.properties` or `.yml`) with:
  * information about default pokemon that every user without any pokemon will get
  * data with some initial users and their pokemons (one pokemon per user)
* Find a way to load configuration file into Spring context and expose initial data as `Map<Strig, String>` 
* Create a `repository` package and inside it create Spring repository class with injected initial data (already in form of the `Map<Strig, String>`)
* Repository implementation should contain the following method:
```java
public String getPokemon(String userName);
```
* The method should return user's pokemon if present, otherwise return default pokemon from configuration
* In test package create test class for your repository with two following tests:
  * check `getPokemon(String userName)` for users with pokemon
  * check `getPokemon(String userName)` for users without pokemon

## Advanced exercise
* Implement the exercise in both ways (with `.properties` and with `.yml` files) on two separate branches
