
package seedu.doraemon;

/**
 * Represents the command to show the content in current list.
 */

public class ListCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        return ui.getListOfTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
