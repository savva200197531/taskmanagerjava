package ru.yandex.taskmanager;

import ru.yandex.taskmanager.manager.HistoryManager;
import ru.yandex.taskmanager.manager.InMemoryTaskManager;
import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.task.Epic;
import ru.yandex.taskmanager.task.SubTask;
import ru.yandex.taskmanager.task.Task;
import ru.yandex.taskmanager.utils.Managers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HistoryManager historyManager = Managers.getDefaultHistory();
        InMemoryTaskManager inMemoryTaskManager = Managers.getDefault(historyManager);


        Task task = new Task("Починить мопед", "Нужно починить мопед, сломалось колесо", inMemoryTaskManager.getCurrentId());
        inMemoryTaskManager.addTask(task);
        Task epic = new Epic("Мастерская", "Бла бла бла", inMemoryTaskManager.getCurrentId());
        inMemoryTaskManager.addTask(epic);
        Task subTask = new SubTask("подзадача в мастерской", "описание задачи", inMemoryTaskManager.getCurrentId(), 1);
        inMemoryTaskManager.addTask(subTask);
        Task subTask1 = new SubTask("подзадача в мастерской", "описание задачи", inMemoryTaskManager.getCurrentId(), 1);
        inMemoryTaskManager.addTask(subTask1);
        Task subTask2 = new SubTask("подзадача в мастерской", "описание задачи", inMemoryTaskManager.getCurrentId(), 1);
        inMemoryTaskManager.addTask(subTask2);
        Task subTask3 = new SubTask("подзадача в мастерской", "описание задачи", inMemoryTaskManager.getCurrentId(), 1);
        inMemoryTaskManager.addTask(subTask3);
        Task epic1 = new Epic("Релиз 2.0", "Описание эпика", inMemoryTaskManager.getCurrentId());
        inMemoryTaskManager.addTask(epic1);
        Task subTask4 = new SubTask("АРМ-1", "описание задачи АРМ1", inMemoryTaskManager.getCurrentId(), 6);
        inMemoryTaskManager.addTask(subTask4);
        Task subTask5 = new SubTask("АРМ-2", "описание задачи АРМ2", inMemoryTaskManager.getCurrentId(), 6);
        inMemoryTaskManager.addTask(subTask5);

        Task currentTask = inMemoryTaskManager.getTask(4);

        System.out.println(currentTask);

        currentTask.setStatus(TaskStatus.IN_PROGRESS);
        currentTask.setDescription(" Добавилось какое то описание");

        inMemoryTaskManager.updateTask(currentTask);

        currentTask = inMemoryTaskManager.getTask(1);

        System.out.println(Arrays.toString(historyManager.getHistory()));
        System.out.println(currentTask);


        List<Task> tasksByEpicId = inMemoryTaskManager.getTasksByEpicId(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(1);

        subTask4.setStatus(TaskStatus.DONE);
        subTask5.setStatus(TaskStatus.DONE);
        inMemoryTaskManager.updateTask(subTask4);
        inMemoryTaskManager.updateTask(subTask5);

        System.out.println(tasksByEpicId);

//        manager.printAllTasks();
//
//        manager.clearTasks();
//
//        manager.printAllTasks();
    }
}