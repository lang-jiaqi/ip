
package seedu.doraemon;

/**
 * Represents the exit command.
 */
public class ExitCommand extends Command {
    // This segment is modified/written by Cursor
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.getByeMessage();
    }
    @Override
    public boolean isExit() {
        return true;
    }


}
