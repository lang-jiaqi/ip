package seedu.doraemon;
public class PriorityListCommand extends ListCommand {
    private int priority;

    public PriorityListCommand(int priority) {
        this.priority = priority;
    }
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        if (priority == 1) {
            return ui.getFirstPriorityTasks(tasks);
        }
        else if (priority == 2) {
            return ui.getMediumPriorityTasks(tasks);
        }
        else if (priority == 3) {
            return ui.getLowPriorityTasks(tasks);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

