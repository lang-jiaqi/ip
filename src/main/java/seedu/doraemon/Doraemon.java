package seedu.doraemon;

/**
 * Represents the main entry point of the Doraemon chatbot application.
 * It initializes the required components (UI, Storage, TaskList) and
 * starts the main command-processing loop.
 */
public class Doraemon {
    private TaskList tasks;
    private final Storage storage;
    private final Ui ui;

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
    public String getResponse(String userInput) {
        try {
            Command command = Parser.parse(userInput);
            String response = command.execute(tasks, ui, storage);
            return response;
        } catch (DoraemonException e) {
            return e.getMessage();
        }
    }
    
    // This segment is modified/written by Cursor
    /**
     * Returns the Ui instance for accessing UI messages.
     * @return The Ui instance
     */
    public Ui getUi() {
        return ui;
    }
}
