package ru.yandex.taskmanager.manager;

import ru.yandex.taskmanager.models.IHistory;
import ru.yandex.taskmanager.task.Task;

public class HistoryManager implements IHistory {
    private final Task[] history = new Task[10];
    int currentHistoryIndex = 0;

    @Override
    public Task[] getHistory() {
        return history;
    }

    @Override
    public void setHistory(Task task) {
        this.history[currentHistoryIndex] = task;
        if (currentHistoryIndex == history.length - 1) {
            currentHistoryIndex = 0;
        } else {
            currentHistoryIndex++;
        }
    }
}