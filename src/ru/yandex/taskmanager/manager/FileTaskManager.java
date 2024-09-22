package ru.yandex.taskmanager.manager;

import ru.yandex.taskmanager.task.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class FileTaskManager extends InMemoryTaskManager {
    public static final String filePath = "src/ru/yandex/taskmanager/filedb/task.csv";

    public FileTaskManager(HistoryManager historyManager) throws IOException {
        super(historyManager);

        getTasksFromFile();
    }


    public void addTask(Task task) throws IOException {
        super.addTask(task);

        save();
    }


    @Override
    public void updateTask(Task task) {
        super.updateTask(task);

        save();
    }

    private void save() {
        try (Writer fileWriter = new FileWriter(filePath)) {
            fileWriter.write("id,type,name,status,description,epic\n");

            System.out.println(currentId);
            for (Task task: tasks.values()) {
                fileWriter.write(task.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("save tasks");
    }

    private void getTasksFromFile() {
        System.out.println("get tasks from file");
    }
}
