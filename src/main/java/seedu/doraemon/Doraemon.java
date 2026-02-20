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
    /**
     * Processes user input and returns a response. The response indicates
     * the message to show and whether the application should exit (e.g. after "bye").
     */
    public Response getResponse(String userInput) {
        try {
            Command command = Parser.parse(userInput);
            String message = command.execute(tasks, ui, storage);
            return new Response(message, command.isExit());
        } catch (DoraemonException e) {
            return new Response(e.getMessage(), false);
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
