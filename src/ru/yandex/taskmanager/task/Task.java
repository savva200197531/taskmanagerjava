package ru.yandex.taskmanager.task;

import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.models.TaskType;
import ru.yandex.taskmanager.utils.DateUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    protected String name;
    protected String description;
    protected int id;
    protected TaskStatus status;
    protected TaskType type;
    protected LocalDateTime startTime;
    protected Duration duration;

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskType getType() {
        return type;
    }

    public Task(String name, String description, int id, TaskType type, LocalDateTime startTime, Duration duration) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.type = type;
        this.status = TaskStatus.TO_DO;
        this.startTime = startTime;
        this.duration = duration;
    }

    public Task(String name, String description, int id, TaskType type, TaskStatus status, LocalDateTime startTime, Duration duration) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.type = type;
        this.status = status;
        this.startTime = startTime;
        this.duration = duration;
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
        Long duration = this.getDuration().getSeconds() / 60;
        String formattedStartTimeString = this.getStartTime().format(DateUtils.formatter);
        return this.getId()
                + "," + this.getType()
                + "," + this.getName()
                + "," + this.getStatus()
                + "," + this.getDescription()
                + "," + formattedStartTimeString
                + "," + duration
                + "," + '\n';
    }
}
