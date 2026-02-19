package seedu.doraemon;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Doraemon doraemon;
    private Ui ui;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/User.png"));
    private Image doraemonImage = new Image(this.getClass().getResourceAsStream("/images/Doraemon.png"));

    @FXML
    // This segment is modified/written by Cursor
    public void initialize() {
        // Bind scrollbar to automatically scroll to bottom when new messages are added
        // Use ChangeListener to update scroll position based on container height changes
        dialogContainer.heightProperty().addListener((observable, oldValue, newValue) -> {
            // Use Platform.runLater to ensure scrolling happens after layout is complete
            Platform.runLater(() -> {
                scrollPane.setVvalue(1.0);
            });
        });
        // Ensure scrollbar is properly configured
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);
    }

    /** Injects the Doraemon instance */
    // This segment is modified/written by Cursor
    public void setDoraemon(Doraemon d) {
        doraemon = d;
        // Display welcome message when app opens
        String welcomeMessage = d.getUi().getWelcomeMessage();
        dialogContainer.getChildren().add(
                DialogBox.getDukeDialog(welcomeMessage, doraemonImage)
        );
        // Scroll to bottom to show welcome message
        Platform.runLater(() -> {
            scrollPane.setVvalue(1.0);
        });
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Doraemon's reply and then appends
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    // This segment is modified/written by Cursor
    private void handleUserInput() {
        String input = userInput.getText();
        String response = doraemon.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, doraemonImage)
        );
        userInput.clear();
        // Ensure scrollbar moves to bottom after adding new messages
        // Use Platform.runLater to ensure scrolling happens after layout is complete
        Platform.runLater(() -> {
            scrollPane.setVvalue(1.0);
        });
    }
}

