package seedu.doraemon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Deals with loading tasks from the file and saving tasks in the file.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructs a Storage object with a specified file path.
     * @param filePath The path of the file to store data.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves all tasks to the disk.
     * Creates the parent directory if it doesn't exist.
     *
     * @param tasks The TaskList containing all tasks to be saved
     * @throws DoraemonException If an error occurs while saving
     */
    public void saveAll(TaskList tasks) throws DoraemonException {
        try {
            File file = new File(filePath);
            assert file != null : "file should not be null";
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            FileWriter fw = new FileWriter(filePath);
            if (!file.canWrite()) {
                throw new IOException("File is not writable: " + filePath);
            }
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.getTask(i);
                assert task != null : "task is null";
                fw.write(task.toFileFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("storage failed " + e.getMessage());
        }

    }

    /**
     * Loads tasks from the disk file.
     * Returns an empty list if the file doesn't exist.
     *
     * @return An ArrayList of tasks loaded from the file
     * @throws DoraemonException If an error occurs while loading
     */
    public ArrayList<Task> loadFromFile() throws DoraemonException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        ArrayList<Task> loadedTasks = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                Task task = parseTaskFromLine(line);
                if (task != null) {
                    loadedTasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            throw new DoraemonException("seedu.doraemon.Doraemon file not found:" + filePath);
        }
        return loadedTasks;
    }

    /**
     * Parses a single line from the file into a Task object.
     *
     * @param line The line to parse, formatted as "TYPE | STATUS | DESCRIPTION | ..."
     * @return The parsed Task object, or null if the line format is invalid
     */
    private Task parseTaskFromLine(String line) {
        String[] parts = line.split(" \\| ");
        assert parts.length >= 3 : "line has too few parts: " + line;
        
        Task task = createTaskFromParts(parts);
        if (task != null && parts[1].equals("1")) {
            task.markAsDone();
        }
        return task;
    }

    /**
     * Creates a Task object from parsed parts of a file line.
     *
     * @param parts The array of parts from splitting the line by " | "
     * @return The created Task object, or null if the task type is unknown
     */
    private Task createTaskFromParts(String[] parts) {
        String taskType = parts[0];
        switch (taskType) {
        case "T":
            return createTodoTask(parts);
        case "D":
            return createDeadlineTask(parts);
        case "E":
            return createEventTask(parts);
        default:
            return null;
        }
    }

    /**
     * Creates a ToDo task from parsed parts.
     *
     * @param parts The array containing task type, status, and description
     * @return The created ToDo task
     */
    private Task createTodoTask(String[] parts) {
        assert parts.length == 3 : "ToDo line must have 3 parts";
        return new ToDo(parts[2]);
    }

    /**
     * Creates a Deadline task from parsed parts.
     *
     * @param parts The array containing task type, status, description, and due date
     * @return The created Deadline task
     */
    private Task createDeadlineTask(String[] parts) {
        assert parts.length == 4 : "Deadline line must have 4 parts";
        LocalDate date = LocalDate.parse(parts[3]);
        return new Deadline(parts[2], date);
    }

    /**
     * Creates an Event task from parsed parts.
     *
     * @param parts The array containing task type, status, description, start date, and end date
     * @return The created Event task
     */
    private Task createEventTask(String[] parts) {
        assert parts.length == 5 : "Event line must have 5 parts";
        LocalDate startTime = LocalDate.parse(parts[3]);
        LocalDate endTime = LocalDate.parse(parts[4]);
        return new Event(parts[2], startTime, endTime);
    }
}
