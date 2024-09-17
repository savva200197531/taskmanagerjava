package ru.yandex.taskmanager.models;

import ru.yandex.taskmanager.task.Task;

import java.util.List;

public interface IHistory {
    List<Task> getHistory();
    void setHistory(Task history);
}
