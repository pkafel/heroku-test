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

# Exercise 2

* Create new package - `controller`
* Inside the package create new Spring's controller class. Your controller should expose the following HTTP API:
  * Resource for asking for users pokemon:
    * HTTP method: GET 
    * url: `/user/{userName}`
    * response HTTP code: 200
    * example response format: `{"user":"albert","pokemon":"psyduck"}`
  * Resource for creation\update of user's pokemon:
    * HTTP method: PUT 
    * url: `/user/{userName}`
    * response HTTP code: 202
    * empty body in response
    * request body: `{"pokemon":"psyduck"}`
    * additional requirement: in case `user` or `pokemon` field is empty service should return 404 with information about missing value

## Advanced exercise
* Add to your project the following dependency:
```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
</dependency>
```
* Remove your manual check for `user` or `pokemon` fields in `PUT` resource
* Put `NotBlank` annotation on top of your fields in request's body class
* Handle Spring's `MethodArgumentNotValidException` and transform it to server response with:
  * HTTP status 400
  * reasonable message
