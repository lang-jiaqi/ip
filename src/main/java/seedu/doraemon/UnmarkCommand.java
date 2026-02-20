
package seedu.doraemon;

/**
 * Represents a command that marks a task as undone.
 */

public class UnmarkCommand extends Command {
    private int taskIndex;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param taskIndex The 1-based index of the task to be marked as not done
     */
    public UnmarkCommand(int taskIndex) {
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
        task.unMark();
        storage.saveAll(tasks);
        return ui.unmarkMessage(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
