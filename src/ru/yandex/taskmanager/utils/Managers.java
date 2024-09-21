package ru.yandex.taskmanager.utils;

import ru.yandex.taskmanager.manager.FileTaskManager;
import ru.yandex.taskmanager.manager.HistoryManager;
import ru.yandex.taskmanager.manager.InMemoryTaskManager;

import java.io.IOException;

public final class Managers {
    public static HistoryManager getDefaultHistory() {
        return new HistoryManager();
    };

    public static InMemoryTaskManager getDefault(HistoryManager historyManager) {
        return new InMemoryTaskManager(historyManager);
    };

    public static FileTaskManager getDefaultFile(HistoryManager historyManager) throws IOException {
        return new FileTaskManager(historyManager);
    };
}