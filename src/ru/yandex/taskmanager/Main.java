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

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {
        HistoryManager historyManager = Managers.getDefaultHistory();
        InMemoryTaskManager inMemoryTaskManager = Managers.getDefault(historyManager);
        FileTaskManager fileTaskManager = Managers.getDefaultFile(historyManager);
//        fileTaskManager.addTask();
//        fileTaskManager.getTasksFromFile();

//        System.out.println("Код работает дальше");
//
//        Task task = new Task(
//                "Починить мопед",
//                "Нужно починить мопед, сломалось колесо",
//                fileTaskManager.getCurrentId(),
//                TaskType.TASK
//        );
//        fileTaskManager.addTask(task);
//        SubTask task1 = new SubTask(
//                "Починить мопед",
//                "Нужно починить мопед, сломалось колесо",
//                fileTaskManager.getCurrentId(),
//                1,
//                TaskType.SUB_TASK
//        );
//        fileTaskManager.addTask(task1);

//        File dir = new File(HOME);

//        System.out.println(File.separator);
//
//        if (dir.isDirectory()) {
//            for (File file : Objects.requireNonNull(dir.listFiles())) {
//                if (file.isDirectory()) {
//                    System.out.println("Каталог: " + file.getName());
//                } else {
//                    System.out.println("Файл: " + file.getName());
//                }
//            }
//        }













        Task task = new Task("Починить мопед", "Нужно починить мопед, сломалось колесо", fileTaskManager.getCurrentId(), TaskType.TASK);
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

        Task currentTask = fileTaskManager.getTask(4);

        System.out.println(currentTask);

        currentTask.setStatus(TaskStatus.IN_PROGRESS);
        currentTask.setDescription(" Добавилось какое то описание");

        fileTaskManager.updateTask(currentTask);

        currentTask = fileTaskManager.getTask(1);

        ;

        System.out.println(currentTask);


        List<Task> tasksByEpicId = fileTaskManager.getTasksByEpicId(1);
//        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
////        inMemoryTaskManager.getTask(1);
//
//        subTask4.setStatus(TaskStatus.DONE);
//        subTask5.setStatus(TaskStatus.DONE);
//        inMemoryTaskManager.updateTask(subTask4);
//        inMemoryTaskManager.updateTask(subTask5);
//
////        inMemoryTaskManager.getTask(3);
////        inMemoryTaskManager.getTask(3);
//        inMemoryTaskManager.getTask(3);
//
//        inMemoryTaskManager.getTask(4);
//
//
//
//        for (Task history: historyManager.getHistory()) {
//            System.out.println("" + history.getId() + history.getDescription() + history.getName());
//        }

//        System.out.println(tasksByEpicId);

//        manager.printAllTasks();
//
//        manager.clearTasks();
//
//        manager.printAllTasks();
    }
}