package seedu.doraemon;

/**
 * Represents an AddCommand.
 * E.g. adding a todo/deadline/event task
 */
public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        tasks.add(task);
        storage.saveAll(tasks);
        return ui.addTaskMessage(task, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
