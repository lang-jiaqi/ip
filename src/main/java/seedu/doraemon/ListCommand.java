<<<<<<< HEAD:src/main/java/doraemon/ListCommand.java
package doraemon;

=======
package seedu.doraemon;

/**
 * Represents the command to show the content in current list.
 */
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/ListCommand.java
public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        ui.showListOfTasks(tasks);
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
