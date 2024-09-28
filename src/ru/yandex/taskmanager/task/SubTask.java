package ru.yandex.taskmanager.task;

import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.models.TaskType;
import ru.yandex.taskmanager.utils.DateUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SubTask extends Task {
    protected int parentId;

    public SubTask(String name, String description, int id, int parentId, TaskType type, LocalDateTime startTime, Duration duration) {
        super(name, description, id, type, startTime, duration);
        this.parentId = parentId;
    }

    public SubTask(String name, String description, int id, int parentId, TaskType type, TaskStatus status, LocalDateTime startTime, Duration duration) {
        super(name, description, id, type, status, startTime, duration);
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
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
                + "," + duration + ","
                + this.getParentId()
                + '\n';
    };
}
