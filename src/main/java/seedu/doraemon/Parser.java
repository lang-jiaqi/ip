
package seedu.doraemon;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Parses user input into executable commands.
 * It interprets the command word and extracts necessary arguments for each action.
 */

public class Parser {
    /** Expected date format for deadline and event. */
    private static final String DATE_FORMAT_HINT = "Invalid date. Expected format: yyyy-MM-dd (e.g. 2025-02-22)";
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
        case "priority":
            return parsePriorityCommand(arguments);
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
     * Format: "description / priority" or just "description" (defaults to priority 2)
     *
     * @param arguments The description and optional priority of the todo task
     * @return An AddCommand containing the todo task
     * @throws DoraemonException If the description is empty or format is invalid
     */
    private static Command parseTodoCommand(String arguments) throws DoraemonException {
        if (arguments.isEmpty()) {
            throw new DoraemonException("The description of a todo cannot be empty");
        }
        
        String[] parts = arguments.split(" / ", 2);
        String description = parts[0].trim();
        int priority = 2; // Default priority
        
        if (parts.length == 2) {
            try {
                priority = Integer.parseInt(parts[1].trim());
                if (priority < 1 || priority > 3) {
                    throw new DoraemonException("Priority must be 1, 2, or 3");
                }
            } catch (NumberFormatException e) {
                throw new DoraemonException("Invalid priority format. Use 1, 2, or 3");
            }
        }
        
        ToDo todo = new ToDo(description, priority);
        return new AddCommand(todo);
    }

    /**
     * Parses a deadline command and creates an AddCommand with a Deadline task.
     * Format: "description / date / priority" or "description / date" (defaults to priority 2)
     *
     * @param arguments The arguments containing description, date, and optional priority
     * @return An AddCommand containing the deadline task
     * @throws DoraemonException If the format is invalid
     */
    private static Command parseDeadlineCommand(String arguments) throws DoraemonException {
        String[] dParts = arguments.split(" / ", 3);
        if (dParts.length < 2) {
            throw new DoraemonException("Deadline format: description / by date [/ priority]");
        }
        
        String description = dParts[0].trim();
        LocalDate date;
        try {
            date = LocalDate.parse(dParts[1].trim());
        } catch (DateTimeParseException e) {
            throw new DoraemonException(DATE_FORMAT_HINT);
        }
        int priority = 2; // Default priority
        
        if (dParts.length == 3) {
            try {
                priority = Integer.parseInt(dParts[2].trim());
                if (priority < 1 || priority > 3) {
                    throw new DoraemonException("Priority must be 1, 2, or 3");
                }
            } catch (NumberFormatException e) {
                throw new DoraemonException("Invalid priority format. Use 1, 2, or 3");
            }
        }
        
        Deadline deadline = new Deadline(description, priority, date);
        return new AddCommand(deadline);
    }

    /**
     * Parses an event command and creates an AddCommand with an Event task.
     * Format: "description / start / end / priority" or "description / start / end" (defaults to priority 2)
     *
     * @param arguments The arguments containing description, start date, end date, and optional priority
     * @return An AddCommand containing the event task
     * @throws DoraemonException If the format is invalid
     */
    private static Command parseEventCommand(String arguments) throws DoraemonException {
        String[] eParts = arguments.split(" / ", 4);
        if (eParts.length < 3) {
            throw new DoraemonException("Event format: description / from start / to end [/ priority]");
        }
        
        String description = eParts[0].trim();
        LocalDate dateFrom;
        LocalDate dateTo;
        try {
            dateFrom = LocalDate.parse(eParts[1].trim());
            dateTo = LocalDate.parse(eParts[2].trim());
        } catch (DateTimeParseException e) {
            throw new DoraemonException(DATE_FORMAT_HINT);
        }
        int priority = 2; // Default priority
        
        if (eParts.length == 4) {
            try {
                priority = Integer.parseInt(eParts[3].trim());
                if (priority < 1 || priority > 3) {
                    throw new DoraemonException("Priority must be 1, 2, or 3");
                }
            } catch (NumberFormatException e) {
                throw new DoraemonException("Invalid priority format. Use 1, 2, or 3");
            }
        }
        
        Event event = new Event(description, priority, dateFrom, dateTo);
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

    /**
     * Parses a priority command and creates a PriorityListCommand.
     *
     * @param arguments The priority level (1, 2, or 3)
     * @return A PriorityListCommand with the specified priority
     * @throws DoraemonException If the priority is invalid
     */
    private static Command parsePriorityCommand(String arguments) throws DoraemonException {
        try {
            int priority = Integer.parseInt(arguments.trim());
            if (priority < 1 || priority > 3) {
                throw new DoraemonException("Priority must be 1, 2, or 3");
            }
            return new PriorityListCommand(priority);
        } catch (NumberFormatException e) {
            throw new DoraemonException("Invalid priority format. Use 1, 2, or 3");
        }
    }
}
