package doraemon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import java.util.ArrayList;

public class StorageTest {

    @Test
    public void testSaveAndLoad_normalTasks_success() throws DoraemonException {
        String testPath = "./data/test_save.txt";
        Storage storage = new Storage(testPath);
        TaskList tasks = new TaskList();
        tasks.add(new ToDo("read book"));

        storage.saveAll(tasks);

        ArrayList<Task> loadedTasks = storage.loadFromFile();

        assertEquals(1, loadedTasks.size());
        assertEquals("read book", loadedTasks.get(0).getDescription());

        new File(testPath).delete();
    }
}