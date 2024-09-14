package ru.yandex.taskmanager.task;

import ru.yandex.taskmanager.models.TaskType;

public class SubTask extends Task {
    protected int parentId;

    public SubTask(String name, String description, int id, int parentId) {
        super(name, description, id);
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }
}
