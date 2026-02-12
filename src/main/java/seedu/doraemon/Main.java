package seedu.doraemon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    final Doraemon doraemon = new Doraemon("./data/seedu.doraemon.Doraemon.txt");

    @Override
    public void start(Stage stage) {
        try {
            stage.setTitle("Doraemon");
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDoraemon(doraemon);
            stage.show();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
