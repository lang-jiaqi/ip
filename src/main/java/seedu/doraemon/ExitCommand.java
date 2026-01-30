<<<<<<< HEAD:src/main/java/doraemon/ExitCommand.java
package doraemon;

=======
package seedu.doraemon;

/**
 * Represents the exit command.
 */
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/ExitCommand.java
public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        return;
    }
    @Override
    public boolean isExit(){
        return true;
    }


}
