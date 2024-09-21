package ru.yandex.taskmanager.manager;

import ru.yandex.taskmanager.task.SubTask;
import ru.yandex.taskmanager.task.Task;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTaskManager extends InMemoryTaskManager {
    public static final String filePath = "src/ru/yandex/taskmanager/filedb/task.csv";
    Path tasksFile = Paths.get(filePath);

    public FileTaskManager(HistoryManager historyManager) throws IOException {
        super(historyManager);

        getTasksFromFile();
    }


    public void addTask(Task task) throws IOException {
        super.addTask(task);

        save();

//        try (Writer fileWriter = new FileWriter(filePath, true)) {
//            fileWriter.write(task.getId() + "," + task.getType() + task.getName() + "," + task.getName() + ",");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

//    public void getTasksFromFile() throws IOException {
//        try (Reader fileReader = new FileReader(String.valueOf(tasksFile))) {
//            BufferedReader br = new BufferedReader(fileReader);
//
//            while (br.ready()) {
//                String line = br.readLine();
//                System.out.println(line);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


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
                System.out.println(task.toString());
//                SubTask subTask = (SubTask) task;
//                String taskToString =
//                fileWriter.write();
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
