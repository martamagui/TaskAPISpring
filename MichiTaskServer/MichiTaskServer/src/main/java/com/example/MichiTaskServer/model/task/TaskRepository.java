package com.example.MichiTaskServer.model.task;

import com.example.MichiTaskServer.model.list.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT s FROM Task s WHERE s.taskId=?1")
    Optional<Task> findTaskByTaskId(Integer taskId);

    @Query("SELECT s FROM Task s WHERE s.listIdFk=?1")
    List<Task> findTaskByListId(@Param("listIdFk") Integer listIdFk);

    @Query("SELECT s FROM Task s")
    List<Task> findAllTask(@Param("listIdFk") Integer listIdFk);

}
