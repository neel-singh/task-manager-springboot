package com.example.Task.Manager.Service;

import com.example.Task.Manager.Entity.TaskEntity;
import com.example.Task.Manager.Exception.TaskNotFoundException;
import com.example.Task.Manager.Repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepo repo;

    public TaskService(TaskRepo repo){
        this.repo = repo;
    }


    // Add Task
    public void addTask(TaskEntity task){
        repo.save(task);
    }


    // Delete Task By I'd
    public void deleteTask(int id){
        if (!repo.existsById(id)) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        repo.deleteById(id);
    }


    // Get Task By I'd
    public Optional<TaskEntity> getTaskById(int id){
        return repo.findById(id);
    }


    // Get Task By Title
    public Optional<TaskEntity> getTaskByTitle(String title){
        return repo.findTaskByTitle(title);
    }


    // Get All Task
    public List<TaskEntity> getAllTask(){
        return repo.findAll();
    }


    // Update Task By Id
    public TaskEntity updateTaskById(int id, TaskEntity updatedTask) {
        TaskEntity existingTask = repo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDue(updatedTask.getDue());
        existingTask.setStatus(updatedTask.isStatus());

        return repo.save(existingTask);
    }


    // Update Task By Title
    public TaskEntity updateTaskByTitle(String title, TaskEntity updatedTask) {
        TaskEntity existingTask = repo.findTaskByTitle(title)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with title: " + title));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDue(updatedTask.getDue());
        existingTask.setStatus(updatedTask.isStatus());

        return repo.save(existingTask);
    }


    // Complete Task By Title
    public void taskCompleted(String title){
        TaskEntity existingTask = repo.findTaskByTitle(title)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with title: " + title));

        existingTask.setStatus(true);
        repo.save(existingTask);
    }


    // Complete Task By I'd
    public void taskCompleted(int id){
        TaskEntity existingTask = repo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        existingTask.setStatus(true);
        repo.save(existingTask);
    }
}