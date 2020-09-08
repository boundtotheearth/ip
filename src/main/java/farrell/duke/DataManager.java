package main.java.farrell.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.farrell.duke.task.Task;
import main.java.farrell.duke.task.TaskList;
import main.java.farrell.duke.task.TaskType;

/**
 * Encapsulates behavior for reading and writing to files.
 */
public class DataManager {
    /** The file name to save and load data from */
    private final String fileName = "data.txt";

    private final String directory = "data/";

    /**
     * Writes the contents of a list of tasks to a file.
     *
     * @param taskList The list of tasks to save.
     * @throws DukeException If a problem is encountered when writing to the file.
     */
    public void save(TaskList taskList) throws DukeException {
        List<Task> tasks = taskList.getAllTasks();
        try {
            File dataDirectory = new File(directory);

            if (!dataDirectory.exists()) {
                dataDirectory.mkdir();
            }

            File dataFile = new File(directory + fileName);

            dataFile.createNewFile();

            FileWriter fw = new FileWriter(dataFile);
            for (Task task : tasks) {
                String data = task.convertToData();
                fw.write(data + "\n");
            }
            fw.close();
        } catch (IOException exception) {
            throw new DukeException("Could not save file!\nReason: " + exception.getMessage());
        }
    }

    /**
     * Loads task data from a file.
     *
     * @return A list of tasks.
     * @throws DukeException If a problem is encountered when opening the file
     */
    public TaskList load() throws DukeException {
        File dataFile = new File(directory + fileName);

        if (!dataFile.exists()) {
            return new TaskList();
        }

        try {
            Scanner sc = new Scanner(dataFile);
            List<Task> taskList = new ArrayList<>();

            while (sc.hasNextLine()) {
                String dataLine = sc.nextLine();
                Task task = convertDataToTask(dataLine);
                taskList.add(task);
            }
            return new TaskList(taskList);
        } catch (FileNotFoundException exception) {
            throw new DukeException("File could not be loaded!");
        }
    }

    private Task convertDataToTask(String dataLine) throws DukeException {
        String[] data = dataLine.split("\\|");
        TaskType taskType = TaskType.enumFromString(data[0]);
        return taskType.getTaskFromData(data);
    }
}
