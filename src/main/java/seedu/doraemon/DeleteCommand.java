
package seedu.doraemon;

/**
 * Represents a command that delete some tasks.
 */
public class DeleteCommand extends Command {
    private int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        if (taskIndex < 1 || taskIndex > tasks.size()) {
            throw new DoraemonException("Invalid task index:" + taskIndex);
        }
        Task removedTask = tasks.delete(taskIndex);
        storage.saveAll(tasks);
        ui.addTaskMessage(removedTask, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
