package com.example.MichiTaskServer.model.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunnerTask(TaskRepository taskRepository){
        return args -> {
            new Task(1,"Titulo","Primera tarea","completada",1);
        };
    }
}
