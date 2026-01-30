package seedu.doraemon;

import java.util.Scanner;

/**
 * Text UI of the application.
 * Deals with interactions with the user, such as printing messages and reading input.
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Prints a horizontal dividing line.
     */
    public void showLine(){
        System.out.println("    ____________________________________________________________");
    }

    public void showWelcomeMessage() {
        showLine();
        System.out.println("    Hello! I'm seedu.doraemon.Doraemon\n    What can I do for you?");
        showLine();
    }

    /**
     * Reads the next line of input from the user.
     * @return The full string entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    public void showByeMessage() {
        System.out.println("    Bye. Hope to see you again soon!");
        showLine();
    }

    /**
     * Shows a list of tasks to the user.
     * @param tasks The TaskList containing tasks to be displayed.
     * @throws DoraemonException If there is an error retrieving tasks.
     */
    public void showListOfTasks(TaskList tasks) throws DoraemonException {
        showLine();
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            Task curr_task = tasks.getTask(i);
            System.out.println("    " + (i + 1) + ". " + curr_task.toString());
        }
        showLine();
    }

    public void markMessage(Task task) {
        showLine();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("      " + task.toString());
        showLine();
    }

    public void UnmarkMessage(Task task) {
        showLine();
        System.out.println("    OK, I've marked this task as not done yet:");
        System.out.println("      " + task.toString());
        showLine();
    }

    public void addTaskMessage(Task task, int taskCount) {
        showLine();
        System.out.println("    Got it. I've added this task:\n" + "    " + task.toString());
        System.out.println("    Now you have " + taskCount + " tasks in your list.");
        showLine();
    }

    public void deleteTaskMessage(Task task, int taskCount) {
        showLine();
        System.out.println("    Noted. I've removed this task:");
        System.out.println("      " + task.toString());
        System.out.println("    Now you have " + taskCount + " tasks in the list.");
        showLine();
    }

    public void showLoadingError() {
        showLine();
    }

    public void showError(String error) {
        showLine();
        System.out.println("    " + error);

    }
}
