package ru.yandex.taskmanager.task;

import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.models.TaskType;

public class Epic extends Task {
    public Epic(String name, String description, int id, TaskType type) {
        super(name, description, id, type);
    }

    public Epic(String name, String description, int id, TaskType type, TaskStatus status) {
        super(name, description, id, type, status);
    }
}
