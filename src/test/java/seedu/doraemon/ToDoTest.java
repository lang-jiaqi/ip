package seedu.doraemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class ToDoTest {
    @Test
    public void testToString_newToDo_correctFormat() {
        ToDo todo = new ToDo("read book", 2);
        assertEquals("[T][ ]read book*2*", todo.toString());
    }

    @Test
    public void testToString_markedToDo_correctFormat() {
        ToDo todo = new ToDo("read book", 1);
        todo.markAsDone();
        assertEquals("[T][X]read book*1*", todo.toString());
    }

    @Test
    public void test_changeStatus_iconChanges() {
        ToDo todo = new ToDo("read book", 2);
        assertFalse(todo.isDone());
        assertEquals("[ ]", todo.getSatusIcon());
        todo.markAsDone();
        assertTrue(todo.isDone());
        assertEquals("[X]", todo.getSatusIcon());
        assertEquals("[T][X]read book*2*", todo.toString());
        todo.unMark();
        assertFalse(todo.isDone());
        assertEquals("[ ]", todo.getSatusIcon());
        assertEquals("[T][ ]read book*2*", todo.toString());
    }

    @Test
    public void testToFileFormat_newToDo_correctFormat() {
        ToDo todo = new ToDo("run marathon", 1);
        assertEquals("T | 0 | run marathon", todo.toFileFormat());
    }

    @Test
    public void testToFileFormat_markedToDo_correctFormat() {
        ToDo todo = new ToDo("run marathon", 1);
        todo.markAsDone();
        assertEquals("T | 1 | run marathon | 1", todo.toFileFormat());
    }

    @Test
    public void testGetDescription_returnsCorrectDescription() {
        ToDo todo = new ToDo("buy groceries", 2);
        assertEquals("buy groceries", todo.getDescription());
    }

    @Test
    public void testIsDone_newToDo_returnsFalse() {
        ToDo todo = new ToDo("test task", 2);
        assertFalse(todo.isDone());
    }

    @Test
    public void testIsDone_markedToDo_returnsTrue() {
        ToDo todo = new ToDo("test task", 3);
        todo.markAsDone();
        assertTrue(todo.isDone());
    }

    @Test
    public void testGetPriority_returnsCorrectPriority() {
        ToDo todo1 = new ToDo("task 1", 1);
        ToDo todo2 = new ToDo("task 2", 2);
        ToDo todo3 = new ToDo("task 3", 3);
        assertEquals(1, todo1.getPriority());
        assertEquals(2, todo2.getPriority());
        assertEquals(3, todo3.getPriority());
    }
}
