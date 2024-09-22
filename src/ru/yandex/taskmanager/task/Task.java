package ru.yandex.taskmanager.task;

import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.models.TaskType;

public class Task {
    protected String name;
    protected String description;
    protected int id;
    protected TaskStatus status;
    protected TaskType type;

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskType getType() {
        return type;
    }

    public Task(String name, String description, int id, TaskType type) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.type = type;
        this.status = TaskStatus.TO_DO;
    }

    public Task(String name, String description, int id, TaskType type, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + "," + this.getType() + "," + this.getName() + "," + this.getStatus() + "," + this.getDescription() + "," + '\n';
    }
}
