
package seedu.doraemon;

import java.time.LocalDate;

/**
 * Parses user input into executable commands.
 * It interprets the command word and extracts necessary arguments for each action.
 */

public class Parser {
    /**
     * Parses the full user input string and returns the corresponding Command object.
     *
     * @param fullCommand The raw input string from the user.
     * @return A Command object that represents the action to be taken.
     * @throws DoraemonException If the command word is unknown or arguments are invalid.
     */

    public static Command parse(String fullCommand) throws DoraemonException {
        assert fullCommand != null : "fullCommand should not be null";
        String[] parts = fullCommand.trim().split(" ", 2);
        String commandWord = parts[0].toLowerCase();
        String arguments = parts.length > 1 ? parts[1] : "";

        switch (commandWord) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return parseIndexCommand(arguments, "mark");
        case "unmark":
            return parseIndexCommand(arguments, "unmark");
        case "delete":
            return parseIndexCommand(arguments, "delete");
        case "todo":
            return parseTodoCommand(arguments);
        case "deadline":
            return parseDeadlineCommand(arguments);
        case "event":
            return parseEventCommand(arguments);
        case "find":
            return parseFindCommand(arguments);
        default:
            throw new DoraemonException("Unknown command: " + commandWord);
        }
    }

    /**
     * Parses an index-based command (mark, unmark, delete).
     *
     * @param arguments The command arguments containing the index
     * @param commandType The type of command ("mark", "unmark", or "delete")
     * @return The corresponding Command object
     * @throws DoraemonException If the index is invalid
     */
    private static Command parseIndexCommand(String arguments, String commandType) throws DoraemonException {
        try {
            int idx = Integer.parseInt(arguments);
            switch (commandType) {
            case "mark":
                return new MarkCommand(idx);
            case "unmark":
                return new UnmarkCommand(idx);
            case "delete":
                return new DeleteCommand(idx);
            default:
                throw new DoraemonException("Invalid index:" + arguments);
            }
        } catch (NumberFormatException e) {
            throw new DoraemonException("Invalid index:" + arguments);
        }
    }

    /**
     * Parses a todo command and creates an AddCommand with a ToDo task.
     *
     * @param arguments The description of the todo task
     * @return An AddCommand containing the todo task
     * @throws DoraemonException If the description is empty
     */
    private static Command parseTodoCommand(String arguments) throws DoraemonException {
        if (arguments.isEmpty()) {
            throw new DoraemonException("The description of a todo cannot be empty");
        }
        ToDo todo = new ToDo(arguments);
        return new AddCommand(todo);
    }

    /**
     * Parses a deadline command and creates an AddCommand with a Deadline task.
     *
     * @param arguments The arguments containing description and date separated by " / "
     * @return An AddCommand containing the deadline task
     * @throws DoraemonException If the format is invalid
     */
    private static Command parseDeadlineCommand(String arguments) throws DoraemonException {
        String[] dParts = arguments.split(" / ", 2);
        if (dParts.length != 2) {
            throw new DoraemonException("seedu.doraemon.Deadline format: description / by date");
        }
        LocalDate date = LocalDate.parse(dParts[1]);
        Deadline deadline = new Deadline(dParts[0], date);
        return new AddCommand(deadline);
    }

    /**
     * Parses an event command and creates an AddCommand with an Event task.
     *
     * @param arguments The arguments containing description, start date, and end date separated by " / "
     * @return An AddCommand containing the event task
     * @throws DoraemonException If the format is invalid
     */
    private static Command parseEventCommand(String arguments) throws DoraemonException {
        String[] eParts = arguments.split(" / ", 3);
        if (eParts.length != 3) {
            throw new DoraemonException("seedu.doraemon.Event format: description / from start / to end");
        }
        LocalDate dateFrom = LocalDate.parse(eParts[1]);
        LocalDate dateTo = LocalDate.parse(eParts[2]);
        Event event = new Event(eParts[0], dateFrom, dateTo);
        return new AddCommand(event);
    }

    /**
     * Parses a find command and creates a FindCommand.
     *
     * @param arguments The keyword to search for
     * @return A FindCommand with the specified keyword
     */
    private static Command parseFindCommand(String arguments) {
        return new FindCommand(arguments);
    }
}
