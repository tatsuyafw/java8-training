package chapter4.exercise08;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyFXML extends Application {
    //@FXML private TextField inputField; // This line is not necessary.

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("exercise08.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
