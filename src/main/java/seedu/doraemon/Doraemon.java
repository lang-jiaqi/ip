package seedu.doraemon;

/**
 * Represents the main entry point of the Doraemon chatbot application.
 * It initializes the required components (UI, Storage, TaskList) and
 * starts the main command-processing loop.
 */
public class Doraemon {
    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    /**
     * Initializes the Doraemon chatbot by loading task data from the specified file.
     * @param filePath The path of the file where task data is stored.
     */
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
    /**
     * Runs the main program loop.
     * It continuously reads user commands, parses them, and executes the actions
     * until the "exit" command is received.
     */
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

    /**
     * Entry point of the Doraemon chatbot.
     * Initializes the application and starts the interaction.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        new Doraemon("./data/seedu.doraemon.Doraemon.txt").run();
    }
}
