
package seedu.doraemon;
import java.util.Scanner;

/**
 * Text UI of the application.
 * Deals with interactions with the user, such as printing messages and reading input.
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);
    public String getWelcomeMessage() {
        return "Hello! I'm Doraemon\nWhat can I do for you?";
    }

    public String getByeMessage() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Shows a list of tasks to the user.
     *
     * @param tasks The TaskList containing tasks to be displayed.
     * @throws DoraemonException If there is an error retrieving tasks.
     */
    public String getListOfTasks(TaskList tasks) throws DoraemonException {
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            Task curr_task = tasks.getTask(i);
            assert curr_task != null : "task is null";
            sb.append((i + 1)).append(". ").append(curr_task.toString()).append("\n");
        }

        return sb.toString();
    }

    public String getKeywordTasks(TaskList tasks, String keyword) throws DoraemonException {
        TaskList keywordTasks = new TaskList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            Task currTask = tasks.getTask(i);
            assert currTask != null : "task is null";
            String taskContent = currTask.getDescription();
            assert taskContent != null : "task description is null";
            String[] taskKeywords = taskContent.trim().split("\\s+");
            for (String taskKeyword : taskKeywords) {
                if (taskKeyword.equals(keyword)) {
                    keywordTasks.add(currTask);
                    break;
                }
            }
        }
        if (keywordTasks.size() == 0) {
            return "Sorry, i haven't find any  tasks to \"" + keyword;
        }
        sb.append("Here are the matching tasks in your list:\n");
        for (int k = 0; k < keywordTasks.size(); k++) {
            Task currTask = keywordTasks.getTask(k);
            assert currTask != null : "task is null";
            sb.append((k + 1)).append(". ").append(currTask.toString()).append("\n");
        }
        return sb.toString();
    }

    public String markMessage(Task task) {
        return "Nice! I've marked this task as done:\n" + "      " + task.toString();
    }

    public String unmarkMessage(Task task) {
        return "Nice! I've unmarked this task as undo:\n" + "      " + task.toString();
    }

    public String addTaskMessage(Task task, int taskCount) {
        return "Got it. I've added this task:"
                + task.toString() + "\n" + "Now you have " + taskCount + " tasks in your list.";
    }

    public String deleteTaskMessage(Task task, int taskCount) {
        return "Noted. I've removed this task:"
                + task.toString() + "\n" + "Now you have " + taskCount + " tasks in your list.";
    }

    public void showLoadingError() {
        System.out.println("Oops, there is a loading error. Please try again.");
    }

    public void showError(String error) {
        System.out.println(error);
    }
}
