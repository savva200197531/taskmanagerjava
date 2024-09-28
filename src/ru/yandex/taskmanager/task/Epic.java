package ru.yandex.taskmanager.task;

import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.models.TaskType;

import java.time.Duration;
import java.time.LocalDateTime;

public class Epic extends Task {
    public Epic(String name, String description, int id, TaskType type, LocalDateTime startTime, Duration duration) {
        super(name, description, id, type, startTime, duration);
    }

    public Epic(String name, String description, int id, TaskType type, TaskStatus status, LocalDateTime startTime, Duration duration) {
        super(name, description, id, type, status, startTime, duration);
    }
}
