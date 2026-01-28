import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Save the tasks to the disk, if the folder doesn't exist,create a folder.
     * @param tasks
     */
    public void saveAll(ArrayList<Task> tasks) {
        try{
            File file = new File(filePath);
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
            FileWriter fw = new FileWriter("./data/Doraemon.txt");
            for (Task task : tasks){
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
    public ArrayList<Task> loadFromFile() {
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
        } catch (IOException e){
            System.out.println("loading failed" + e.getMessage());
        }
        return loadedTasks;
    }
}
