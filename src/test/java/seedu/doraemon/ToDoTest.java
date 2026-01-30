package seedu.doraemon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void testToString_newToDo_correctFormat() {
        ToDo todo = new ToDo("read book");
        assertEquals("[T][ ]read book", todo.toString());
    }

    @Test
    public void test_changeStatus_iconChanges() {
        ToDo todo = new ToDo("read book");
        todo.markAsDone();
        assertEquals("[X]", todo.getSatusIcon());
        assertEquals("[T][X]read book", todo.toString());
        todo.Unmark();
        assertEquals("[T][ ]read book", todo.toString());
    }

    @Test
    public void testToFileFormat_correctData() {
        ToDo todo = new ToDo("run marathon");
        assertEquals("T | 0 | run marathon", todo.toFileFormat());
    }
}
