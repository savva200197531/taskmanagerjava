package ru.yandex.taskmanager.manager;

import ru.yandex.taskmanager.models.IHistory;
import ru.yandex.taskmanager.task.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class HistoryManager implements IHistory {
    static public int MAX_LIST_SIZE = 10;
    private LinkedHashMap<Integer, Task> tasksLinkedHashMap = new LinkedHashMap<>();

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(tasksLinkedHashMap.values());
    }

    @Override
    public void setHistory(Task task) {
        int taskId = task.getId();

        tasksLinkedHashMap.remove(taskId);
        tasksLinkedHashMap.put(taskId, task);


        if (tasksLinkedHashMap.size() >= HistoryManager.MAX_LIST_SIZE) {
            Task i = (Task) tasksLinkedHashMap.entrySet().toArray()[tasksLinkedHashMap.size() -1];
            tasksLinkedHashMap.remove(i.getId());
            tasksLinkedHashMap.remove(0);
        }
    }
}