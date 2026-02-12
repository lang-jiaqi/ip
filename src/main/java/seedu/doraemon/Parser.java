
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
        String commandWord = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";

        switch (commandWord) {
        case"bye":
            return new ExitCommand();
        case"list":
            return new ListCommand();
        case"mark":
            try {
                int idx = Integer.parseInt(parts[1]);
                return new MarkCommand(idx);
            } catch (NumberFormatException e) {
                throw new DoraemonException("Invalid index:" + arguments);
            }
        case"unmark":
            try {
                int idx = Integer.parseInt(parts[1]);
                return new UnmarkCommand(idx);
            } catch (NumberFormatException e) {
                throw new DoraemonException("Invalid index:" + arguments);
            }
        case"delete":
            try {
                int idx = Integer.parseInt(parts[1]);
                return new DeleteCommand(idx);
            } catch (NumberFormatException e) {
                throw new DoraemonException("Invalid index:" + arguments);
            }
        case"todo":
            String[] tParts = arguments.split("/", 2);
            if (arguments.isEmpty()) {
                throw new DoraemonException("The description of a todo cannot be empty");
            }
            ToDo todo = new ToDo(tParts[0], Integer.parseInt(tParts[1]));
            return new AddCommand(todo);
        case"deadline":
            String[] dParts = arguments.split("/", 3);
            if (dParts.length != 2) {
                throw new DoraemonException("seedu.doraemon.Deadline format: description / by date");
            }
            LocalDate date = LocalDate.parse(dParts[1]);
            Deadline deadline = new Deadline(dParts[0], Integer.parseInt(dParts[2]), date);
            return new AddCommand(deadline);
        case"event":
            String[] eParts = arguments.split("/", 4);
            if (eParts.length != 3) {
                throw new DoraemonException("seedu.doraemon.Event format: description / from start / to end");
            }
            LocalDate dateFrom = LocalDate.parse(eParts[1]);
            LocalDate dateTo = LocalDate.parse(eParts[2]);
            Event event = new Event(eParts[0], Integer.parseInt(eParts[3]), dateFrom, dateTo);
            return new AddCommand(event);
        case"find":
            String keyword = arguments;
            return new FindCommand(keyword);
        case"priority":
            return new PriorityListCommand( Integer.parseInt(arguments));

        default:
            throw new DoraemonException("Unknown command: " + commandWord);

        }
    }
}
