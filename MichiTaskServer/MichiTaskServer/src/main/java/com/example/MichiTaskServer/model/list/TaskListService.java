package com.example.MichiTaskServer.model.list;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {
    private TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }
    public List<TaskList> getTaskList(){
        return taskListRepository.findAll();
    }

}
