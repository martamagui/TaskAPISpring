package com.example.MichiTaskServer.model.task;

import com.example.MichiTaskServer.model.list.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT s FROM Task s WHERE s.taskId=?1")
    Optional<Task> findTaskByTaskId(Integer taskId);
}
