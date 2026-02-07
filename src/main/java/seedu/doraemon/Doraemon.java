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
    public String getResponse(String input) {
        try {
            String fullCommand = input;
            Command c = Parser.parse(fullCommand);
            return c.execute(tasks, ui, storage);
        } catch (DoraemonException e) {
            return ui.showError(e.getMessage());
        }
    }
}
