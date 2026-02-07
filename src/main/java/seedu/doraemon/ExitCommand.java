
package seedu.doraemon;

/**
 * Represents the exit command.
 */
public class ExitCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return null;
    }
    @Override
    public boolean isExit() {
        return true;
    }


}
