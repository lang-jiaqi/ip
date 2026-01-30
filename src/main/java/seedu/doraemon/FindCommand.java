package seedu.doraemon;

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
