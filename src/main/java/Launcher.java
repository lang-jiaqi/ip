import javafx.application.Application;
import seedu.doraemon.Main;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {
    /**
     * Launches the JavaFX application.
     * This method is used as a workaround for classpath issues when running JavaFX applications.
     *
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}

