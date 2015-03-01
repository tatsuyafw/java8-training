package chapter4.exercise06;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyGridrPane extends Application {
	public void start(Stage stage) {
		GridPane pane = new GridPane();
		Button top    = new Button("Top");
		Button left   = new Button("Left");
		Button center = new Button("Center");
		Button right  = new Button("Right");
		Button bottom = new Button("Bottom");
		pane.add(top, 1, 0);
		pane.add(left, 0, 1);
		pane.add(center, 1, 1);
		pane.add(right, 2, 1);
		pane.add(bottom, 1, 2);
		GridPane.setHalignment(top, HPos.CENTER);
		GridPane.setHalignment(center, HPos.CENTER);
		GridPane.setHalignment(bottom, HPos.CENTER);

		stage.setScene(new Scene(pane));
		stage.setResizable(false);
		stage.setTitle(this.getClass().getSimpleName());
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
