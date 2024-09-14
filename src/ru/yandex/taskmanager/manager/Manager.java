package ru.yandex.taskmanager.manager;
import ru.yandex.taskmanager.models.IManager;
import ru.yandex.taskmanager.task.SubTask;
import ru.yandex.taskmanager.task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Manager implements IManager {
    HashMap<Integer, Task> tasks;
    protected int currentId;

    public Manager() {
        currentId = 0;
        tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
        this.setCurrentId();
    }

    public void printAllTasks() {
        for (Task task : tasks.values()) {
            System.out.println(task.getId() + " " + task.getName() + " " + task.getDescription());
        }
    }

    public void clearTasks() {
        tasks.clear();
        this.setCurrentId(0);
    }

    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId() {
        this.currentId += 1;
    }
    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public List<Task> getTasksByEpicId(int epicId) {
        List<Task> tasksByEpicId = tasks.values().stream().filter(task -> task instanceof SubTask && ((SubTask) task).getParentId() == epicId).collect(Collectors.toList());

        return tasksByEpicId;
    }
}
