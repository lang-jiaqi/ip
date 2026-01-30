<<<<<<< HEAD:src/main/java/doraemon/Storage.java
package doraemon;
=======
package seedu.doraemon;
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/Storage.java

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Deals with loading tasks from the file and saving tasks in the file.
 */
public class Storage {
    private String filePath;

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
        try{
            File file = new File(filePath);
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
<<<<<<< HEAD:src/main/java/doraemon/Storage.java
            FileWriter fw = new FileWriter(filePath);
=======
            FileWriter fw = new FileWriter("./data/seedu.doraemon.Doraemon.txt");
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/Storage.java
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.getTask(i);
                fw.write(task.toFileFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e){
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
        if(!file.exists()){
            return loadedTasks;
        }

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] parts = line.split(" \\| ");
                Task t = null;

                switch (parts[0]) {
                    case "T":
                        t = new ToDo(parts[2]);
                        break;
                    case "D":
                        t = new Deadline(parts[2],parts[3]);
                        break;
                    case "E":
                        t = new Event(parts[2],parts[3],parts[4]);
                        break;
                }
                if (t!= null) {
                    if(parts[1].equals("1")){
                        t.markAsDone();
                    }
                    loadedTasks.add(t);
                }
                String type = parts[0];
                boolean  isDone = parts[1].equals("1");
            }
        } catch (FileNotFoundException e) {
<<<<<<< HEAD:src/main/java/doraemon/Storage.java
            throw new DoraemonException("seedu.doraemon.Ui.Doraemon file not found:" + filePath);
=======
            throw new DoraemonException("seedu.doraemon.Doraemon file not found:" + filePath);
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/Storage.java
        }
        return loadedTasks;
    }
}
