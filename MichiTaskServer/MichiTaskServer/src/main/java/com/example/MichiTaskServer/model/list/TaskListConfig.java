package com.example.MichiTaskServer.model.list;

import com.example.MichiTaskServer.model.user.User;
import com.example.MichiTaskServer.model.user.UserRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskListConfig {
    @Bean
    CommandLineRunner commandTaskLineRunner(TaskListRepository taskListRepository){
        return args ->{
            TaskList taskList =  new TaskList(1,"Mi primer Lista",1);
        };
    }
}
