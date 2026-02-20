
package seedu.doraemon;
import java.util.Scanner;

/**
 * Text UI of the application.
 * Deals with interactions with the user, such as printing messages and reading input.
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * Returns the welcome message displayed when the application starts.
     *
     * @return The welcome message string
     */
    public String getWelcomeMessage() {
        return "Hi I am Doraemon, your personal schedule assistant! Welcome to tell me anything!";
    }

    /**
     * Returns the goodbye message displayed when the user exits the application.
     *
     * @return The goodbye message string
     */
    public String getByeMessage() {
        return "BYE! I have remembered all schedule till now. See u next time!";
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

    /**
     * Searches for tasks containing the specified keyword and returns a formatted string.
     *
     * @param tasks The TaskList to search through
     * @param keyword The keyword to search for in task descriptions
     * @return A formatted string containing matching tasks, or an error message if none found
     * @throws DoraemonException If there is an error retrieving tasks
     */
    public String getKeywordTasks(TaskList tasks, String keyword) throws DoraemonException {
        TaskList keywordTasks = new TaskList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            Task currTask = tasks.getTask(i);
            assert currTask != null : "task is null";
            String taskContent = currTask.getDescription();
            assert taskContent != null : "task description is null";
            if (taskContent.contains(keyword)) {
                keywordTasks.add(currTask);
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

    /**
     * Returns a message indicating that a task has been marked as done.
     *
     * @param task The task that was marked as done
     * @return A formatted message string
     */
    public String markMessage(Task task) {
        return "Nice! I've marked this task as done:\n" + "      " + task.toString();
    }

    /**
     * Returns a message indicating that a task has been unmarked.
     *
     * @param task The task that was unmarked
     * @return A formatted message string
     */
    public String unmarkMessage(Task task) {
        return "Nice! I've unmarked this task as undo:\n" + "      " + task.toString();
    }

    /**
     * Returns a message indicating that a task has been added to the list.
     *
     * @param task The task that was added
     * @param taskCount The total number of tasks in the list after adding
     * @return A formatted message string
     */
    public String addTaskMessage(Task task, int taskCount) {
        return "Got it. I've added this task:"
                + task.toString() + "\n" + "Now you have " + taskCount + " tasks in your list.";
    }

    /**
     * Returns a message indicating that a task has been deleted from the list.
     *
     * @param task The task that was deleted
     * @param taskCount The total number of tasks in the list after deletion
     * @return A formatted message string
     */
    public String deleteTaskMessage(Task task, int taskCount) {
        return "Noted. I've removed this task:"
                + task.toString() + "\n" + "Now you have " + taskCount + " tasks in your list.";
    }

    /**
     * Displays a loading error message to the console.
     */
    public void showLoadingError() {
        System.out.println("Oops, there is a loading error. Please try again.");
    }

    /**
     * Displays an error message to the console.
     *
     * @param error The error message to display
     */
    public void showError(String error) {
        System.out.println(error);
    }
}
