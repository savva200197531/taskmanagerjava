package ru.yandex.taskmanager;

import ru.yandex.taskmanager.manager.FileTaskManager;
import ru.yandex.taskmanager.manager.HistoryManager;
import ru.yandex.taskmanager.manager.InMemoryTaskManager;
import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.models.TaskType;
import ru.yandex.taskmanager.task.Epic;
import ru.yandex.taskmanager.task.SubTask;
import ru.yandex.taskmanager.task.Task;
import ru.yandex.taskmanager.utils.Managers;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {
        HistoryManager historyManager = Managers.getDefaultHistory();
//        InMemoryTaskManager inMemoryTaskManager = Managers.getDefault(historyManager);
        FileTaskManager fileTaskManager = Managers.getDefaultFile(historyManager);

        Task task = new Task("Починить мопед", "Нужно починить мопед сломалось колесо", fileTaskManager.getCurrentId(), TaskType.TASK);
        fileTaskManager.addTask(task);
        Task epic = new Epic("Мастерская", "Бла бла бла", fileTaskManager.getCurrentId(), TaskType.EPIC);
        fileTaskManager.addTask(epic);
        Task subTask = new SubTask("подзадача в мастерской", "описание задачи", fileTaskManager.getCurrentId(), 1, TaskType.SUB_TASK);
        fileTaskManager.addTask(subTask);
        Task subTask1 = new SubTask("подзадача в мастерской", "описание задачи", fileTaskManager.getCurrentId(), 1, TaskType.SUB_TASK);
        fileTaskManager.addTask(subTask1);
        Task subTask2 = new SubTask("подзадача в мастерской", "описание задачи", fileTaskManager.getCurrentId(), 1, TaskType.SUB_TASK);
        fileTaskManager.addTask(subTask2);
        Task subTask3 = new SubTask("подзадача в мастерской", "описание задачи", fileTaskManager.getCurrentId(), 1, TaskType.SUB_TASK);
        fileTaskManager.addTask(subTask3);
        Task epic1 = new Epic("Релиз 2.0", "Описание эпика", fileTaskManager.getCurrentId(), TaskType.EPIC);
        fileTaskManager.addTask(epic1);
        Task subTask4 = new SubTask("АРМ-1", "описание задачи АРМ1", fileTaskManager.getCurrentId(), 6, TaskType.SUB_TASK);
        fileTaskManager.addTask(subTask4);
        Task subTask5 = new SubTask("АРМ-2", "описание задачи АРМ2", fileTaskManager.getCurrentId(), 6, TaskType.SUB_TASK);
        fileTaskManager.addTask(subTask5);
//
        Task currentTask = fileTaskManager.getTask(4);
//
//        System.out.println(currentTask);
//
        currentTask.setStatus(TaskStatus.IN_PROGRESS);
        currentTask.setDescription(" Добавилось какое то описание");
//
        fileTaskManager.updateTask(currentTask);
//
        currentTask = fileTaskManager.getTask(1);

//        System.out.println(currentTask);


        List<Task> tasksByEpicId = fileTaskManager.getTasksByEpicId(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
        fileTaskManager.getTask(1);
//
        subTask4.setStatus(TaskStatus.DONE);
        subTask5.setStatus(TaskStatus.DONE);
        fileTaskManager.updateTask(subTask4);
        fileTaskManager.updateTask(subTask5);

        fileTaskManager.getTask(3);
        fileTaskManager.getTask(3);
        fileTaskManager.getTask(3);

        fileTaskManager.getTask(4);



//        for (Task history: historyManager.getHistory()) {
//            System.out.println("" + history.getId() + history.getDescription() + history.getName());
//        }

//        System.out.println(tasksByEpicId);

//        manager.printAllTasks();
//
//        fileTaskManager.clearTasks();
//
//        manager.printAllTasks();
        System.out.println("finish");
    }
}