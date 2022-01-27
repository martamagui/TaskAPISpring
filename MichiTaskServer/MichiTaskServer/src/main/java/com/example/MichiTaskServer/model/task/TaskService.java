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
    public List<Task> getTasks(){return taskRepository.findAll();}

    public void addTask(Task task) {
        if(taskRepository.findTaskByTaskId(task.getTaskId()).isPresent()){
            throw new IllegalStateException("Task Id already taken.");
        }else{
            taskRepository.save(task);
        }
    }

    public void delete(Integer taskId) {
        if(taskRepository.findTaskByTaskId(taskId).isPresent()){
            taskRepository.deleteById(taskId);
        }else{
            throw new IllegalStateException("This Task doesn't exist.");
        }
    }
    @Transactional
    public void editTask(Integer taskId, String taskTitle, String description, String state) {
        if(taskRepository.findTaskByTaskId(taskId).isPresent()){
            Task task = taskRepository.findTaskByTaskId(taskId).get();
            if(taskTitle!=null){
                task.setTitle(taskTitle);
            }
            if(description!=null){
                task.setDescription(description);
            }
            if(state!=null){
                task.setState(state);
            }
        }else{
            throw new IllegalStateException("This Task doesn't exist.");
        }
    }

    public List<Task> tasksByListId(Integer listIdFk) {
        return taskRepository.findTaskByListId(listIdFk);
    }
}
