package com.example.MichiTaskServer.model.task;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "{listIdFk}")
    public List<Task> getTasksbyId(@PathVariable("listIdFk") Integer listIdFk) {
        return taskService.tasksByListId(listIdFk);
    }

    @PostMapping
    public void addTask(Task task) {
        taskService.addTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteUser(@PathVariable("taskId") Integer taskId) {
        taskService.delete(taskId);
    }

    //No pongo que se pueda cambiar el fk de la lista porque de moento no panteo que se puedan migrar als tareas de lista a lista
    @PutMapping(path = "{taskId}")
    public void editTask(@PathVariable("taskId") Integer taskId,
                         @RequestParam(required = false) String taskTitle,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) String state) {
        taskService.editTask(taskId, taskTitle, description, state);
    }
}
