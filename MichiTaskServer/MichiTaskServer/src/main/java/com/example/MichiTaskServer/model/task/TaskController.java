package com.example.MichiTaskServer.model.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping(path = "bylistId/{listIdFk}")
    public List<Task> getTasksbyListId(@PathVariable("listIdFk") Integer listIdFk) {
        return taskService.tasksByListId(listIdFk);
    }
    @GetMapping(path = "{taskId}")
    public Task getTaskbyId(@PathVariable("taskId") Integer taskId) {
        return taskService.getTaskbyId(taskId);
    }

    @PostMapping
    public void addTask(Task task) {
        taskService.addTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable("taskId") Integer taskId) {

        if(taskService.delete(taskId)){
            return new ResponseEntity<Integer>(taskId,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //No pongo que se pueda cambiar el fk de la lista porque de moento no panteo que se puedan migrar als tareas de lista a lista
    @PutMapping(path = "{taskId}")
    public Task editTask(@PathVariable("taskId") Integer taskId,
                         @RequestParam(required = false) String title,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) String state) {
        return taskService.editTask(taskId, ttle, description, state);
    }
}
