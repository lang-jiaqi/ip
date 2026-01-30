
package seedu.doraemon;

/**
 * An abstract class af all command
 */
public abstract class Command {
    /**
     * Executes a command, give reaction on the UI and store into the disk.
     * @param tasks
     * @param ui
     * @param storage
     * @throws DoraemonException
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException;

    /**
     * checks whether it is an exit command.
     * @return
     */
    public abstract boolean isExit();
}
