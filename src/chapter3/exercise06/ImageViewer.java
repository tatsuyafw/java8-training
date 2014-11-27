package chapter3.exercise06;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImageViewer extends Application {
    @Override
    public void start(Stage stage) {
        Image image;
        image = new Image("https://duke.kenai.com/brazil/.Midsize/SoccerDuke.png.png");

        Image transformedImage = Transformer.transform(image,
                (c, factor) -> c.deriveColor(0,  1,  factor, 1), 2.0);

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