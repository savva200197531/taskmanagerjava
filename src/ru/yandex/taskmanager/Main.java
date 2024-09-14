package ru.yandex.taskmanager;

import ru.yandex.taskmanager.manager.Manager;
import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.task.Epic;
import ru.yandex.taskmanager.task.SubTask;
import ru.yandex.taskmanager.task.Task;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Task task = new Task("Починить мопед", "Нужно починить мопед, сломалось колесо", manager.getCurrentId());
        manager.addTask(task);
        Task epic = new Epic("Мастерская", "Бла бла бла", manager.getCurrentId());
        manager.addTask(epic);
        Task subTask = new SubTask("подзадача в мастерской", "описание задачи", manager.getCurrentId(), 1);
        manager.addTask(subTask);
        Task subTask1 = new SubTask("подзадача в мастерской", "описание задачи", manager.getCurrentId(), 1);
        manager.addTask(subTask1);
        Task subTask2 = new SubTask("подзадача в мастерской", "описание задачи", manager.getCurrentId(), 1);
        manager.addTask(subTask2);
        Task subTask3 = new SubTask("подзадача в мастерской", "описание задачи", manager.getCurrentId(), 1);
        manager.addTask(subTask3);
        Task epic1 = new Epic("Релиз 2.0", "Описание эпика", manager.getCurrentId());
        manager.addTask(epic1);
        Task subTask4 = new SubTask("АРМ-1", "описание задачи АРМ1", manager.getCurrentId(), 6);
        manager.addTask(subTask4);
        Task subTask5 = new SubTask("АРМ-2", "описание задачи АРМ2", manager.getCurrentId(), 6);
        manager.addTask(subTask5);

        Task currentTask = manager.getTaskById(4);
        System.out.println(currentTask);

        currentTask.setStatus(TaskStatus.IN_PROGRESS);
        currentTask.setDescription(" Добавилось какое то описание");

        manager.updateTask(currentTask);

        currentTask = manager.getTaskById(1);
        System.out.println(currentTask);


        List<Task> tasksByEpicId = manager.getTasksByEpicId(1);

        subTask4.setStatus(TaskStatus.DONE);
        subTask5.setStatus(TaskStatus.DONE);
        manager.updateTask(subTask4);
        manager.updateTask(subTask5);

        System.out.println(tasksByEpicId);

//        manager.printAllTasks();
//
//        manager.clearTasks();
//
//        manager.printAllTasks();
    }
}