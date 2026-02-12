
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
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        boolean taskIndaxInvalid = taskIndex < 1 || taskIndex > tasks.size();
        if (taskIndaxInvalid) {
            throw new DoraemonException("Invalid task index:" + taskIndex);
        }
        Task removedTask = tasks.delete(taskIndex);
        storage.saveAll(tasks);
        return ui.addTaskMessage(removedTask, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
