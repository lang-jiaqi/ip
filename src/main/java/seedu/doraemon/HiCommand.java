package seedu.doraemon;

/**
 * Shows a short usage guide when the user types "hi".
 */
public class HiCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return String.join("\n",
                "Hi! Here is a quick guide:",
                "",
                "• todo:       todo DESCRIPTION [PRIORITY]",
                "  e.g. todo read book [2]",
                "",
                "• deadline:   deadline DESCRIPTION / DATE [PRIORITY]",
                "  e.g. deadline submit report / 2025-02-22 [1]",
                "",
                "• event:      event DESCRIPTION / START_DATE / END_DATE [PRIORITY]",
                "  e.g. event project meeting / 2025-02-22 / 2025-02-23 [3]",
                "",
                "• mark/unmark/delete: mark 1, unmark 1, delete 1",
                "• list:       show all tasks",
                "• find:       find KEYWORD",
                "• priority:   priority 1 (or 2 / 3) to list tasks by priority",
                "• bye:        exit the app",
                "",
                "Note: PRIORITY must be [1], [2], or [3], and dates use yyyy-MM-dd (e.g. 2025-02-22)."
        );
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

