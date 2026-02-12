
package seedu.doraemon;

/**
 * Represents a command that marks a task as undone.
 */

public class UnmarkCommand extends Command {
    private int taskIndex;

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
