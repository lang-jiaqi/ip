package seedu.doraemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class ToDoTest {
    @Test
    public void testToString_newToDo_correctFormat() {
        ToDo todo = new ToDo("read book");
        assertEquals("[T][ ]read book", todo.toString());
    }

    @Test
    public void testToString_markedToDo_correctFormat() {
        ToDo todo = new ToDo("read book");
        todo.markAsDone();
        assertEquals("[T][X]read book", todo.toString());
    }

    @Test
    public void test_changeStatus_iconChanges() {
        ToDo todo = new ToDo("read book");
        assertFalse(todo.isDone());
        assertEquals("[ ]", todo.getSatusIcon());
        todo.markAsDone();
        assertTrue(todo.isDone());
        assertEquals("[X]", todo.getSatusIcon());
        assertEquals("[T][X]read book", todo.toString());
        todo.unMark();
        assertFalse(todo.isDone());
        assertEquals("[ ]", todo.getSatusIcon());
        assertEquals("[T][ ]read book", todo.toString());
    }

    @Test
    public void testToFileFormat_newToDo_correctFormat() {
        ToDo todo = new ToDo("run marathon");
        assertEquals("T | 0 | run marathon", todo.toFileFormat());
    }

    @Test
    public void testToFileFormat_markedToDo_correctFormat() {
        ToDo todo = new ToDo("run marathon");
        todo.markAsDone();
        assertEquals("T | 1 | run marathon", todo.toFileFormat());
    }

    @Test
    public void testGetDescription_returnsCorrectDescription() {
        ToDo todo = new ToDo("buy groceries");
        assertEquals("buy groceries", todo.getDescription());
    }

    @Test
    public void testIsDone_newToDo_returnsFalse() {
        ToDo todo = new ToDo("test task");
        assertFalse(todo.isDone());
    }

    @Test
    public void testIsDone_markedToDo_returnsTrue() {
        ToDo todo = new ToDo("test task");
        todo.markAsDone();
        assertTrue(todo.isDone());
    }
}
