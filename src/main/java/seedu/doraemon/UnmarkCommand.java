
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
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        if (taskIndex < 1 || taskIndex > tasks.size()) {
            throw new DoraemonException("Invalid task index:" + taskIndex);
        }
        Task task = tasks.getTask(taskIndex - 1);
        task.unMark();
        storage.saveAll(tasks);
        ui.unmarkMessage(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
