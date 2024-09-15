package ru.yandex.taskmanager.utils;

import ru.yandex.taskmanager.manager.HistoryManager;
import ru.yandex.taskmanager.manager.InMemoryTaskManager;

public final class Managers {
    public static HistoryManager getDefaultHistory() {
        return new HistoryManager();
    };

    public static InMemoryTaskManager getDefault(HistoryManager historyManager) {
        return new InMemoryTaskManager(historyManager);
    };
}