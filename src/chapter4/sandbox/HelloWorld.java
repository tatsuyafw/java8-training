package chapter4.sandbox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {
	public void start(Stage stage) {
		Label message = new Label("Hello, JavaFX!!");
		message.setFont(new Font(50));
		TextField text = new TextField("Hello, JavaFX!!");
		text.setFont(new Font(50));
		message.textProperty().bind(text.textProperty());
		/*BorderPane pane = new BorderPane();
		pane.setTop(message);
		pane.setBottom(text);
		stage.setScene(new Scene(pane));
		*/
		VBox vbox = new VBox();
		vbox.getChildren().addAll(message, text);
		stage.setScene(new Scene(vbox));
		//stage.setScene(new Scene(message));
		stage.setTitle("Hello");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
