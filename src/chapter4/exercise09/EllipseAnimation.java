package chapter4.exercise09;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * うまく bind できず、月は断念...
 */
public class EllipseAnimation extends Application {
    public static final double SUN_RADIUS = 20f;
    public static final double EARTH_RADIUS = 10f;

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.BLACK);

        stage.setScene(scene);
        stage.setTitle(this.getClass().getSimpleName());
        stage.setResizable(false);

        Circle sun = new Circle(scene.getWidth() / 2, scene.getHeight() / 2, SUN_RADIUS);
        sun.setFill(Color.CRIMSON);
        root.getChildren().add(sun);

        Circle earth = new Circle(EARTH_RADIUS);
        earth.setFill(Color.DODGERBLUE);
        root.getChildren().add(earth);

        Ellipse earthPath = new Ellipse(scene.getWidth() / 2, scene.getHeight() / 2, 200, 170);
        PathTransition earthPathTransition = new PathTransition();
        earthPathTransition.setDuration(Duration.millis(5000));
        earthPathTransition.setNode(earth);
        earthPathTransition.setPath(earthPath);
        earthPathTransition.setCycleCount(Animation.INDEFINITE);
        earthPathTransition.setInterpolator(Interpolator.LINEAR);
        earthPathTransition.play();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
