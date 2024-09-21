package ru.yandex.taskmanager.task;

import ru.yandex.taskmanager.models.TaskType;

public class SubTask extends Task {
    protected int parentId;

    public SubTask(String name, String description, int id, int parentId, TaskType type) {
        super(name, description, id, type);
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    @Override
    public String toString() {
        return this.getId() + "," + this.getType() + this.getName() + "," + this.getStatus() + "," + this.getDescription() + "," + this.getParentId() + '\n';
    };
}
