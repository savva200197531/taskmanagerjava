package ru.yandex.taskmanager.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.taskmanager.models.TaskType;
import ru.yandex.taskmanager.task.Task;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileTaskManagerTest {
    private static FileTaskManager taskManager;
    private static HistoryManager historyManager;

    @BeforeEach
    void setUp() throws IOException {
        historyManager = new HistoryManager();
        taskManager = new FileTaskManager(historyManager, "src/ru/yandex/taskmanager/filedb/task-tests.csv");
    }

    @AfterEach
    void tearDown() {
        taskManager.clearTasks();
    }

    @Test
    void addTask() throws IOException {
        Task task = new Task("Починить мопед", "Нужно починить мопед сломалось колесо", taskManager.getCurrentId(), TaskType.TASK);
        taskManager.addTask(task);

        assertNotNull(taskManager.getTask(0));
    }

    @Test
    void clearTasks() throws IOException {
        List<Task> tasks = List.of(
                new Task("Починить мопед", "Нужно починить мопед сломалось колесо", 0, TaskType.TASK),
                new Task("Починить мопед", "Нужно починить мопед сломалось колесо", 1, TaskType.TASK),
                new Task("Починить мопед", "Нужно починить мопед сломалось колесо", 2, TaskType.TASK)
        );

        for (Task task : tasks) {
            taskManager.addTask(task);
        }

        assertEquals(3, taskManager.tasks.size());

        taskManager.clearTasks();

        assertEquals(0, taskManager.tasks.size());
    }

    @Test
    void updateTask() throws IOException {
        Task task = new Task("Починить мопед", "Нужно починить мопед сломалось колесо", 0, TaskType.TASK);
        taskManager.addTask(task);

        assertEquals("Починить мопед", taskManager.getTask(0).getName());

        task.setName("Починить сцепление");
        taskManager.updateTask(task);

        assertEquals("Починить сцепление", taskManager.getTask(0).getName());
    }

    @Test
    void fillSubtasks() throws IOException {
        assertEquals(0, taskManager.tasks.size());

        String taskString = "0,TASK,Починить мопед,TO_DO,Нужно починить мопед,";

        taskManager.fillSubtasks(taskString);

        assertEquals(1, taskManager.tasks.size());

        assertEquals("Починить мопед", taskManager.getTask(0).getName());
    }
}