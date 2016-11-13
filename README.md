# Open Tech School Spring Boot workshops 

## Exercise 1

* Create two packages in you project:
  * config
  * repository
* In `src/main/java/resources` create `application.properties` file with two properties:
  * `pokemon.default` and assign to it name of your favorite pokemon
  * `pokemon.init_data` and assign to it string that will represent users and their favorite pokemon in parsable way. Example: `lucy-pikachu;piotr-charmander;albert-ditto`
* In `config` package create Spring configuration class that will inject value of `pokemon.init_data`, transform it into `Map<Strig, String>` and expose it as a bean
* In `repository` package create Spring repository class which will autowire `Map<Strig, String>` from the mentioned earlier configuration and contains the following method with proper implmentation:
```java
public String getPokemon(String userName);
```
* In test package create test for your repository and test if it behave in expected way (need to clarify this a bit more...)
