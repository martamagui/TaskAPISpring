package com.example.MichiTaskServer.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User,Integer> {
    @Query("SELECT s FROM User s WHERE s.userId=?1")
    Optional<User> findUserById(Integer userId);
}
