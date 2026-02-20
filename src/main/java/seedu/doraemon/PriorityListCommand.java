package seedu.doraemon;

/**
 * Represents a command that lists tasks filtered by priority level.
 */
public class PriorityListCommand extends ListCommand {
    private int priority;

    /**
     * Constructs a PriorityListCommand with the specified priority level.
     *
     * @param priority The priority level (1, 2, or 3)
     */
    public PriorityListCommand(int priority) {
        this.priority = priority;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        if (priority == 1) {
            return ui.getFirstPriorityTasks(tasks);
        } else if (priority == 2) {
            return ui.getMediumPriorityTasks(tasks);
        } else if (priority == 3) {
            return ui.getLowPriorityTasks(tasks);
        } else {
            throw new DoraemonException("Invalid priority level: " + priority + ". Must be 1, 2, or 3.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

