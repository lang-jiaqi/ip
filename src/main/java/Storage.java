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

    public void save(ArrayList<Task> tasks) {
        try{
            File folder = new File("./data");
            if(!folder.exists()){
                folder.mkdir();
            }
            FileWriter fw = new FileWriter("./data/Doraemon.txt", true);
            for (Task task : tasks) {
                fw.write(task.toFileFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e){
            System.out.println("storage failed " + e.getMessage());
        }

    }

    public void loadFromFile(ArrayList<Task> tasks) {
        File file = new File("./data/Doraemon.txt");
        if(!file.exists()){
            return;
        }

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean  isDone = parts[1].equals("1");
            }
        } catch (IOException e){
            System.out.println("loading failed" + e.getMessage());
        }
    }
}
