package com.example.MichiTaskServer.model.list;

import com.example.MichiTaskServer.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "lists")
public class TaskList {
    @Id
    @Column(name="list_id")
    private Integer listId;
    private String name;
    @Column(name="user_id_fk")
    private Integer userIdFk;

    public TaskList() {
    }

    public TaskList(Integer listId, String name, Integer userIdFk) {
        this.listId = listId;
        this.name = name;
        this.userIdFk = userIdFk;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "listId=" + listId +
                ", name='" + name + '\'' +
                ", user='" + userIdFk.toString() + '\'' +
                '}';
    }
}
