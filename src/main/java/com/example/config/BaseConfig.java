package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class BaseConfig {

    @Value("${pokemon.init_data}")
    private String initData;

    @Bean
    public Map<String, String> getInitData() {
        return Arrays.stream(initData.split(";"))
                .collect(Collectors.toMap(
                        singleEntry -> singleEntry.split("-")[0], singleEntry -> singleEntry.split("-")[1]));
    }
}
