package com.example.Task.Manager.Controller;

import com.example.Task.Manager.Entity.TaskEntity;
import com.example.Task.Manager.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    //
    @PostMapping("/task")
    public ResponseEntity<Void> addTask(TaskEntity task){
        taskService.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    //
    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


    //
    @GetMapping("/task/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable int id){
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    //
    @GetMapping("/task/title/{title}")
    public ResponseEntity<TaskEntity> getTaskByTitle(@PathVariable String title){
        return taskService.getTaskByTitle(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    //
    @GetMapping("/task")
    public ResponseEntity<List<TaskEntity>> getAllTask(){
        return ResponseEntity.ok(taskService.getAllTask());
    }


    //
    @PutMapping("/task/{id}")
    public TaskEntity updateTaskById(@PathVariable int id, TaskEntity updatedTask){
        return taskService.updateTaskById(id, updatedTask);
    }


    //
    @PutMapping("/task/title/{title}")
    public ResponseEntity<TaskEntity> updateTaskByTitle(@PathVariable String title, TaskEntity updatedTask){
        return ResponseEntity.ok(taskService.updateTaskByTitle(title, updatedTask));
    }


    //
    @PatchMapping("/task/{id}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable int id){
        taskService.taskCompleted(id);
        return ResponseEntity.ok().build();
    }
}
