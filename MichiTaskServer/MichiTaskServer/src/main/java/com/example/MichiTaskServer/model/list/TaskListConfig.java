package com.example.MichiTaskServer.model.list;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskListConfig {
    @Bean
    CommandLineRunner commandLineRunnerTaskList(TaskListRepository taskListRepository){
        return args ->{
            TaskList taskList =  new TaskList(1,"Mi primer Lista",1);
        };
    }
}
