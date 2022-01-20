package com.example.MichiTaskServer.model.list;

import com.example.MichiTaskServer.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/list" )
public class TaskListController {
    private TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }
    @GetMapping
    public List<TaskList> getUsers(){
        return taskListService.getTaskList();
    }
}
