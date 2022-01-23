package com.example.MichiTaskServer.model.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "task_id")
    private Integer taskId;
    private String title;
    private String description;
    private String state;
    @Column(name = "list_id_fk")
    private Integer listIdFk;

    public Task() {
    }

    public Task(Integer taskId, String title, String description, String state, Integer listIdFk) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.state = state;
        this.listIdFk = listIdFk;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getListIdFk() {
        return listIdFk;
    }

    public void setListIdFk(Integer listIdFk) {
        this.listIdFk = listIdFk;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", listIdFk=" + listIdFk +
                '}';
    }
}

