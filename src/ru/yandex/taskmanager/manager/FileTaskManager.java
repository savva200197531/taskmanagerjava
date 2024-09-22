package ru.yandex.taskmanager.manager;

import ru.yandex.taskmanager.models.TaskStatus;
import ru.yandex.taskmanager.models.TaskType;
import ru.yandex.taskmanager.task.Epic;
import ru.yandex.taskmanager.task.SubTask;
import ru.yandex.taskmanager.task.Task;
import ru.yandex.taskmanager.utils.CommonUtil;

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
    }


    @Override
    public void updateTask(Task task) {
        super.updateTask(task);

        save();
    }

    @Override
    public void clearTasks() {
        super.clearTasks();
        save();
    }

    private void save() {
        try (Writer fileWriter = new FileWriter(filePath)) {
            fileWriter.write("id,type,name,status,description,epic\n");

            for (Task task: tasks.values()) {
                fileWriter.write(task.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getTasksFromFile() {
        System.out.println("get tasks from file");

        try (Reader fileReader = new FileReader(String.valueOf(tasksFile))) {
            BufferedReader br = new BufferedReader(fileReader);

            boolean isTitle = true;

            while (br.ready()) {
                String line = br.readLine();

                if (!isTitle) {
                    this.fillSubtasks(line);
                }

                if (isTitle) {
                    isTitle = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillSubtasks(String line) throws IOException {
        String[] columns = line.split(",");
        String name = CommonUtil.prepareString(columns[2]);
        String description = CommonUtil.prepareString(columns[4]);
        int id = Integer.parseInt(CommonUtil.prepareString(columns[0]));
        TaskStatus status = TaskStatus.valueOf(CommonUtil.prepareString(columns[3]));
        TaskType type = TaskType.valueOf(CommonUtil.prepareString(columns[1]));

        switch (type) {
            case TASK:
                Task task = new Task(name, description, id, type, status);
                this.addTask(task);
                break;
            case EPIC:
                Epic epic = new Epic(name, description, id, type, status);
                this.addTask(epic);
                break;
            case SUB_TASK:
                int parentId = Integer.parseInt(CommonUtil.prepareString(columns[5]));
                SubTask subTask = new SubTask(name, description, id, parentId, type, status);
                this.addTask(subTask);
                break;
        }
    }
}
