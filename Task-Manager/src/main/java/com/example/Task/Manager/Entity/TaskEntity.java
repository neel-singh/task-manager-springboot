package com.example.Task.Manager.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;

@Data
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime date;

    @Column(unique = true, nullable = false)
    private String title;

    private String description;

    @Future
    private LocalDateTime due;

    private boolean status;

    @PrePersist
    public void onCreate(){
        this.date = LocalDateTime.now();
    }
}
