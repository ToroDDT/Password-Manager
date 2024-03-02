package com.example.Backend.Configurations;

import com.example.Backend.Animals.Parrot;
import com.example.Backend.Animals.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "BackendApplication")
public class ProjectConfig {
    @Bean
    Parrot parrot () {
        var p = new Parrot();
        p.setName("David");
        return p;
    }
    @Bean
    String hello () {
        return "hi";
    }
    @Bean
    Integer ten() {
        return 10;
    }
}
