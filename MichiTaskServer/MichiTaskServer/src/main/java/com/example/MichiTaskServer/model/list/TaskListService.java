package com.example.MichiTaskServer.model.list;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public void addTakslist(TaskList taskList){
        if(taskListRepository.findTaskListById(taskList.getListId()).isPresent()){
            throw new IllegalStateException("This list alredy exist.");
        }else{
            taskListRepository.save(taskList);
        }
    }

    public void delete(Integer taskListId) {
        if(taskListRepository.findTaskListById(taskListId).isPresent()){
            throw new IllegalStateException("This list alredy exist.");
        }else{
            taskListRepository.deleteById(taskListId);
        }
    }
    @Transactional
    public void editTaskList(Integer taskListId, String name) {
        if(taskListRepository.findTaskListById(taskListId).isPresent()){
            TaskList taskList = taskListRepository.findTaskListById(taskListId).get();
        }else{
            throw new IllegalStateException("List not found");
        }
    }
}
