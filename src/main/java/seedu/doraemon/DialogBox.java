package seedu.doraemon;
import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Represents a dialog box consisting of an ImageView to represent the speaker's face
 * and a label containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(img);
    }


    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Creates a dialog box for user messages.
     * User messages are right-aligned with the avatar on the right side.
     * 
     * @param text The message text to display
     * @param img The user's avatar image
     * @return A DialogBox configured for user messages
     */
    // This segment is modified/written by Cursor
    public static DialogBox getUserDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        // Right-align user messages for better visual distinction
        db.setAlignment(Pos.TOP_RIGHT);
        // Allow the HBox to expand to full width for proper alignment
        db.setMaxWidth(Double.MAX_VALUE);
        // Set to fill available width
        HBox.setHgrow(db, Priority.ALWAYS);
        return db;
    }

    /**
     * Creates a dialog box for Doraemon's (bot) messages.
     * Bot messages are left-aligned with the avatar on the left side.
     * Applies the "reply-label" CSS class for distinct styling.
     * 
     * @param text The message text to display
     * @param img Doraemon's avatar image
     * @return A DialogBox configured for bot messages
     */
    // This segment is modified/written by Cursor
    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        // Apply reply-label CSS class to differentiate bot messages with different color
        db.dialog.getStyleClass().add("reply-label");
        // Flip to put avatar on left and text on right
        db.flip();
        // Allow the HBox to expand to full width for proper alignment
        db.setMaxWidth(Double.MAX_VALUE);
        // Set to fill available width
        HBox.setHgrow(db, Priority.ALWAYS);
        return db;
    }
}
