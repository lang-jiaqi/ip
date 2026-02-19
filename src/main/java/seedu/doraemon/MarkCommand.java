
package seedu.doraemon;

/**
 * Represents the command that mark a task is done.
 */

public class MarkCommand extends Command {
    private int taskIndex;

    /**
     * Constructs a MarkCommand with the specified task index.
     *
     * @param taskIndex The 1-based index of the task to be marked as done
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        boolean taskIndexInvalid = taskIndex < 1 || taskIndex > tasks.size();
        if (taskIndexInvalid) {
            throw new DoraemonException("Invalid task index:" + taskIndex);
        }
        Task task = tasks.getTask(taskIndex - 1);
        assert task != null : "task is null";
        task.markAsDone();
        storage.saveAll(tasks);
        return ui.markMessage(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }

}
