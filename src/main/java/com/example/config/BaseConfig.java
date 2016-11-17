package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties(BaseConfig.PokemonProperties.class)
public class BaseConfig {

    @ConfigurationProperties("pokemon")
    public static class PokemonProperties {

        private Map<String, String> init;

        private String defaultPokemon;

        public Map<String, String> getInit() {
            return init;
        }

        public void setInit(Map<String, String> init) {
            this.init = init;
        }

        public String getDefaultPokemon() {
            return defaultPokemon;
        }

        public void setDefaultPokemon(String defaultPokemon) {
            this.defaultPokemon = defaultPokemon;
        }
    }
}
