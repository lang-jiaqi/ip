package seedu.doraemon;

/**
 * Wraps the chatbot response and whether the application should exit.
 */
public class Response {
    private final String message;
    private final boolean exit;

    public Response(String message, boolean exit) {
        this.message = message;
        this.exit = exit;
    }

    public String getMessage() {
        return message;
    }

    public boolean isExit() {
        return exit;
    }
}
