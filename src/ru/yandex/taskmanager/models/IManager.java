package ru.yandex.taskmanager.models;

import ru.yandex.taskmanager.task.Task;

import java.util.List;

public interface IManager {
    void addTask(Task task);
    void printAllTasks();
    void clearTasks();
    int getCurrentId();
    void setCurrentId();
    void updateTask(Task task);
    List<Task> getTasksByEpicId(int epicId);
    Task getTask(int id);
}
