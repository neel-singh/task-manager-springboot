package com.example.Task.Manager.Repo;

import com.example.Task.Manager.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {
    Optional<TaskEntity> findTaskByTitle(String title);
}
