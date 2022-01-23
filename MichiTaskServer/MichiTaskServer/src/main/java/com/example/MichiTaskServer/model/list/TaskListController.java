package com.example.MichiTaskServer.model.list;

import com.example.MichiTaskServer.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/list")
public class TaskListController {
    private TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    public List<TaskList> getTaskList() {
        return taskListService.getTaskList();
    }

    @PostMapping
    public List<TaskList> addTasList(@RequestBody TaskList taskList) {
        taskListService.addTakslist(taskList);
        return taskListService.getTaskList();
    }

    @DeleteMapping(path = "{taskListId}")
    public void deleteTaskList(@PathVariable("taskListId") Integer taskListId) {
        taskListService.delete(taskListId);
    }

    @PutMapping(path = "{taskListId}")
    public void editTaskList(@PathVariable("taskListId") Integer taskListId,
                             @RequestParam(required = true) String name) {
        taskListService.editTaskList(taskListId, name);
    }
}
