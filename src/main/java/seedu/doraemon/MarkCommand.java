<<<<<<< HEAD:src/main/java/doraemon/MarkCommand.java
package doraemon;

=======
package seedu.doraemon;

/**
 * Represents the command that mark a task is done.
 */
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/MarkCommand.java
public class MarkCommand extends Command {
    private int  taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException{
        if (taskIndex < 1 || taskIndex > tasks.size()) {
            throw new DoraemonException("Invalid task index:" + taskIndex);
        }
        Task task = tasks.getTask(taskIndex - 1);
        task.markAsDone();
        storage.saveAll(tasks);
        ui.markMessage(task);
    }

    @Override
    public boolean isExit(){
        return false;
    }

}
