package com.zhihuang.ontodo.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String task;

    private String description;

    private Long userId;

    private Boolean isGroupTask;

    private List<Long> subTaskId;

    public Task() {
    }

    private String status;

}
