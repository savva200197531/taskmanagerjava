package ru.yandex.taskmanager.manager;

import ru.yandex.taskmanager.models.IHistory;
import ru.yandex.taskmanager.task.Task;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HistoryManager implements IHistory {
    static public int MAX_LIST_SIZE = 10;
    private LinkedList<Task> tasksLinkedList = new LinkedList<>();
    private Map<Integer, Task> historyTaskLink = new HashMap<>();

    @Override
    public List<Task> getHistory() {
        return tasksLinkedList.subList(0, tasksLinkedList.size());
    }

    @Override
    public void setHistory(Task task) {
        if (historyTaskLink.containsKey(task.getId())) {
            Task linkedTask = historyTaskLink.get(task.getId());
            tasksLinkedList.remove(linkedTask);
        }

        historyTaskLink.put(task.getId(), task);
        tasksLinkedList.addFirst(task);

        if (tasksLinkedList.size() >= HistoryManager.MAX_LIST_SIZE) {
            tasksLinkedList.removeLast();
        }
    }
}