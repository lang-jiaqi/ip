package seedu.doraemon;

/**
 * A class that represents a command that find tasks with a keyword
 */
public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        ui.showKeywordTasks(tasks, keyword);

    }
    @Override
    public boolean isExit() {
        return false;
    }
}
