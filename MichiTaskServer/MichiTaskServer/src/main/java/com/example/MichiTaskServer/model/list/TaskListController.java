package com.example.MichiTaskServer.model.list;

import com.example.MichiTaskServer.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Integer> deleteTaskList(@PathVariable("taskListId") Integer taskListId) {
        if(taskListService.delete(taskListId)){
            return new ResponseEntity<Integer>(taskListId, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "{taskListId}")
    public void editTaskList(@PathVariable("taskListId") Integer taskListId,
                             @RequestParam(required = true) String name) {
        taskListService.editTaskList(taskListId, name);
    }
}
