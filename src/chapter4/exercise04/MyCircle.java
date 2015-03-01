package chapter4.exercise04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyCircle extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.WHITE);
		stage.setScene(scene);

		Circle circle = new Circle(100);
		circle.setFill(Color.STEELBLUE);
		root.getChildren().add(circle);

		circle.radiusProperty().bind(
				Bindings.createDoubleBinding(() -> {
					double diameter = Math.min(scene.getWidth(), scene.getHeight());
					return diameter / 2;
				}, scene.widthProperty(), scene.heightProperty())
	    );
		circle.centerXProperty().bind(scene.widthProperty().divide(2));
		circle.centerYProperty().bind(scene.heightProperty().divide(2));

		stage.setTitle(this.getClass().getSimpleName());
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
