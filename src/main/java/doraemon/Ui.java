package doraemon;

import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void showLine(){
        System.out.println("    ____________________________________________________________");
    }

    public void showWelcomeMessage() {
        showLine();
        System.out.println("    Hello! I'm seedu.doraemon.Ui.Doraemon\n    What can I do for you?");
        showLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showByeMessage() {
        System.out.println("    Bye. Hope to see you again soon!");
        showLine();
    }

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

    /**
     * Represents the seedu.doraemon.Ui.Doraemon chatbot.
     */
    public static class Doraemon {
        TaskList tasks;
        Storage storage;
        Ui ui;

        public Doraemon(String filePath) {
            ui = new Ui();
            storage = new Storage(filePath);
            try {
                tasks = new TaskList(storage.loadFromFile());
            } catch (DoraemonException e) {
                ui.showLoadingError();
                tasks = new TaskList();
            }
        }

        public void run() {
            ui.showWelcomeMessage();
            boolean isExit = false;
            while (!isExit) {
                try {
                    String fullCommand = ui.readCommand();
                    Command c = Parser.parse(fullCommand);
                    c.execute(tasks, ui, storage);
                    isExit = c.isExit();
                } catch (DoraemonException e) {
                    ui.showError(e.getMessage());
                }
            }
            ui.showByeMessage();
        }


        public static void main(String[] args) {
            new Doraemon("./data/seedu.doraemon.Ui.Doraemon.txt").run();
        }
    }
}
