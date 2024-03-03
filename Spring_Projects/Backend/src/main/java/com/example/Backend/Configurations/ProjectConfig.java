package com.example.Backend.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class ProjectConfig {

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory (){
        return new LocalSessionFactoryBean();
    }
}
