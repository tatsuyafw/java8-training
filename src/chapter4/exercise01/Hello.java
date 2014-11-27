package chapter4.exercise01;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Hello extends Application {
	private static final String TITLE = "Hello";
	private static final int LABEL_FONT_SIZE = 50;
	private static final int VIEW_FONT_SIZE = 100;
	private static final String MESSAGE_STRING = "Hello, JavaFX";

	public void start(Stage stage) {
		Label messageLabel = new Label("Label: ");
		Label textLabel = new Label("Text: ");
		Label message = new Label(MESSAGE_STRING);
		TextField text = new TextField(MESSAGE_STRING);
		
		messageLabel.setFont(new Font(LABEL_FONT_SIZE));
		textLabel.setFont(new Font(LABEL_FONT_SIZE));
		message.setFont(new Font(VIEW_FONT_SIZE));
		text.setFont(new Font(VIEW_FONT_SIZE));
		text.setPadding(new Insets(0));
		
		message.textProperty().bind(text.textProperty());

		GridPane pane = new GridPane();
		pane.add(messageLabel, 0, 0);
		pane.add(message, 1, 0);
		pane.add(textLabel, 0, 1);
		pane.add(text, 1, 1);
		GridPane.setHalignment(messageLabel, HPos.RIGHT);
		GridPane.setHalignment(textLabel, HPos.RIGHT);

		pane.setPadding(new Insets(5));
		stage.setScene(new Scene(pane));		
		stage.setTitle(TITLE);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
