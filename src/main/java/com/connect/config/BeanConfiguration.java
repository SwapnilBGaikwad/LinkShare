package com.connect.config;

import com.connect.model.Credential;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
class BeanConfiguration {
    @Bean
    Map<String,Credential> getMap() {
        return new HashMap<>();
    }
}
