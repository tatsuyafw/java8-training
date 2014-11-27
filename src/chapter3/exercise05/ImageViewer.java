package chapter3.exercise05;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageViewer extends Application {
    @Override
    public void start(Stage stage) {
        Image image;
        image = new Image("https://duke.kenai.com/brazil/.Midsize/SoccerDuke.png.png");

        int borderWidth = 10;
        Image transformedImage = Transformer.transform(image, (x, y, color) -> {
            if ( x < borderWidth || y < borderWidth
                    || x >= (image.getWidth() - borderWidth)
                    || y >= (image.getHeight() - borderWidth)) {
                return Color.GRAY;
            } else {
                return color;
            }
        });

        ImageView iv = new ImageView(transformedImage);
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(iv);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}