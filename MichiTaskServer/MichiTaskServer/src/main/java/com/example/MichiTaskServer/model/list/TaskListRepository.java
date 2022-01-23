package com.example.MichiTaskServer.model.list;

import com.example.MichiTaskServer.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskListRepository extends JpaRepository<TaskList,Integer> {
    @Query("SELECT t FROM TaskList t WHERE t.listId=?1")
    Optional<TaskList> findTaskListById(Integer taskListId);
}
