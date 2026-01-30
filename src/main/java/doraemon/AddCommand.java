package doraemon;

/**
 * Represents a command to add a task to the task list.
 * This class encapsulates the action of adding a task, which includes updating
 * the in-memory list, persisting the change to storage, and notifying the user via the UI.
 */
public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        tasks.add(task);
        storage.saveAll(tasks);
        ui.addTaskMessage(task, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
