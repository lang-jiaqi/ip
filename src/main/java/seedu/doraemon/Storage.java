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
     * Save the tasks to the disk, if the folder doesn't exist,create a folder.
     * @param tasks
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
     * load the tasks from the disk, if the file doesn't exist, just return.
     * @return an arraylist of asks
     */
    public ArrayList<Task> loadFromFile() throws DoraemonException {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(" \\| ");
                assert parts.length >= 3 : "line has too few parts: " + line;
                Task t = null;
                switch (parts[0]) {
                case"T":
                    assert parts.length == 3 : "ToDo line must have 3 parts: " + line;
                    t = new ToDo(parts[2]);
                    break;
                case"D":
                    assert parts.length == 4 : "Deadline line must have 4 parts: " + line;
                    LocalDate date = LocalDate.parse(parts[3]);
                    t = new Deadline(parts[2], date);
                    break;
                case"E":
                    assert parts.length == 5 : "Event line must have 5 parts: " + line;
                    LocalDate startTime = LocalDate.parse(parts[3]);
                    LocalDate endTime = LocalDate.parse(parts[4]);
                    t = new Event(parts[2], startTime, endTime);
                    break;
                default:
                    break;
                }
                if (t != null) {
                    loadedTasks.add(t);
                    if (parts[1].equals("1")) {
                        t.markAsDone();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DoraemonException("seedu.doraemon.Doraemon file not found:" + filePath);
        }
        return loadedTasks;
    }
}
