
package seedu.doraemon;

/**
 * An abstract class af all command
 */
public abstract class Command {
    /**
     * Executes the command, updates the UI, and saves changes to storage.
     *
     * @param tasks The task list to operate on
     * @param ui The UI component for displaying messages
     * @param storage The storage component for persisting data
     * @return A response message to be displayed to the user
     * @throws DoraemonException If an error occurs during command execution
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException;

    /**
     * Checks whether this command is an exit command.
     *
     * @return True if this is an exit command, false otherwise
     */
    public abstract boolean isExit();
}
