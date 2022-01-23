package com.example.MichiTaskServer.model.list;

import javax.persistence.*;

@Entity
@Table(name = "lists")
public class TaskList {
    @Id
    @Column(name = "list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listId;
    private String name;
    @Column(name = "user_id_fk")
    private Integer userFk;

    public TaskList() {
    }

    public TaskList(Integer listId, String name, Integer userIdFk) {
        this.listId = listId;
        this.name = name;
        this.userFk = userIdFk;
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

    public Integer getUserFk() {
        return userFk;
    }

    public void setUserFk(Integer userFk) {
        this.userFk = userFk;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "listId=" + listId +
                ", name='" + name + '\'' +
                ", user='" + userFk.toString() + '\'' +
                '}';
    }
}
