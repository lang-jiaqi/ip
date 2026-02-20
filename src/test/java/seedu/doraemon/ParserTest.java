package seedu.doraemon;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class ParserTest {

    @Test
    public void testParse_validCommands_success() throws DoraemonException {
        assertTrue(Parser.parse("bye") instanceof ExitCommand);
        assertTrue(Parser.parse("list") instanceof ListCommand);
        assertTrue(Parser.parse("todo read book") instanceof AddCommand);
        assertTrue(Parser.parse("find book") instanceof FindCommand);
    }

    @Test
    public void testParse_unknownCommand_throwsException() {
        assertThrows(DoraemonException.class, () -> {
            Parser.parse("unknown");
        });
    }

    @Test
    public void testParse_emptyTodo_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("todo");
        });
        assertTrue(exception.getMessage().contains("description of a todo cannot be empty"));
    }

    @Test
    public void testParse_invalidMarkIndex_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("mark abc");
        });
        assertTrue(exception.getMessage().contains("Invalid index"));
    }

    @Test
    public void testParse_invalidUnmarkIndex_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("unmark xyz");
        });
        assertTrue(exception.getMessage().contains("Invalid index"));
    }

    @Test
    public void testParse_invalidDeleteIndex_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("delete invalid");
        });
        assertTrue(exception.getMessage().contains("Invalid index"));
    }

    @Test
    public void testParse_deadlineMissingDate_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("deadline finish project");
        });
        assertTrue(exception.getMessage().contains("Deadline format"));
    }

    @Test
    public void testParse_deadlineInvalidFormat_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("deadline finish project /");
        });
        assertTrue(exception.getMessage().contains("Deadline format"));
    }

    @Test
    public void testParse_eventMissingDates_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("event conference");
        });
        assertTrue(exception.getMessage().contains("Event format"));
    }

    @Test
    public void testParse_eventMissingEndDate_throwsException() {
        DoraemonException exception = assertThrows(DoraemonException.class, () -> {
            Parser.parse("event conference / 2026-03-01");
        });
        assertTrue(exception.getMessage().contains("Event format"));
    }

    @Test
    public void testParse_caseInsensitive_success() throws DoraemonException {
        assertTrue(Parser.parse("BYE") instanceof ExitCommand);
        assertTrue(Parser.parse("LIST") instanceof ListCommand);
        assertTrue(Parser.parse("TODO test") instanceof AddCommand);
        assertTrue(Parser.parse("Mark 1") instanceof MarkCommand);
    }

    @Test
    public void testParse_validMarkCommand_success() throws DoraemonException {
        Command command = Parser.parse("mark 1");
        assertTrue(command instanceof MarkCommand);
    }

    @Test
    public void testParse_validUnmarkCommand_success() throws DoraemonException {
        Command command = Parser.parse("unmark 2");
        assertTrue(command instanceof UnmarkCommand);
    }

    @Test
    public void testParse_validDeleteCommand_success() throws DoraemonException {
        Command command = Parser.parse("delete 3");
        assertTrue(command instanceof DeleteCommand);
    }

    @Test
    public void testParse_validDeadlineCommand_success() throws DoraemonException {
        Command command = Parser.parse("deadline finish / 2026-02-20");
        assertTrue(command instanceof AddCommand);
    }

    @Test
    public void testParse_validEventCommand_success() throws DoraemonException {
        Command command = Parser.parse("event meeting / 2026-03-01 / 2026-03-03");
        assertTrue(command instanceof AddCommand);
    }
}
