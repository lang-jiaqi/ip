package seedu.doraemon;

/**
 * Represents an exception specific to the seedu.doraemon.Doraemon application.
 */
public class DoraemonException extends Exception {
    /**
     * Constructs a DoraemonException with the specified error message.
     *
     * @param message The error message describing what went wrong
     */
    public DoraemonException(String message) {
        super(message);
    }
}
