package com.example.MichiTaskServer.model.task;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskbyId(Integer taskId) {
        return taskRepository.findTaskByTaskId(taskId).get();
    }

    public boolean addTask(Task task) {
        if (taskRepository.findTaskByTaskId(task.getTaskId()).isPresent()) {
            throw new IllegalStateException("Task Id already taken.");
        } else {
            taskRepository.save(task);
        }
        return true;
    }


    public boolean delete(Integer taskId) {
        if (taskRepository.findTaskByTaskId(taskId).isPresent()) {
            taskRepository.deleteById(taskId);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Task editTask(Integer taskId, String taskTitle, String description, String state) {
        if (taskRepository.findTaskByTaskId(taskId).isPresent()) {
            Task task = taskRepository.findTaskByTaskId(taskId).get();
            System.out.println(taskTitle + " " + description + " " + state);
            if (taskTitle != null) {
                task.setTitle(taskTitle);
            }
            if (description != null) {
                task.setDescription(description);
            }
            if (state != null) {
                task.setState(state);
            }
        } else {
            throw new IllegalStateException("This Task doesn't exist.");
        }
        Task task2 = taskRepository.findTaskByTaskId(taskId).get();
        return task2;
    }

    public List<Task> tasksByListId(Integer listIdFk) {
        return taskRepository.findTaskByListId(listIdFk);
    }


    public int getmyTaskId() {
        List<Task> lista = taskRepository.findAll();
        return (lista.size() + 1);
    }
}
