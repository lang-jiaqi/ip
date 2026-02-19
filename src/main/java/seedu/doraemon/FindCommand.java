package seedu.doraemon;

/**
 * A class that represents a command that find tasks with a keyword
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Constructs a FindCommand with the specified keyword to search for.
     *
     * @param keyword The keyword to search for in task descriptions
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        return ui.getKeywordTasks(tasks, keyword);

    }
    @Override
    public boolean isExit() {
        return false;
    }
}
