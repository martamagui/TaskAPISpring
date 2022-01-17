package com.example.MichiTaskServer.model.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRespository respository){
        return args ->{
            User user = new User(2,"Laika","Magui","laika@gmail.com","1234");
        };
    }
}
