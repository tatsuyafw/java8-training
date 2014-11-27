package chapter3.exercise12;

import static chapter3.exercise12.ColorTransformer.createColorTransformer;
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

        int borderWidth = 20;
        ColorTransformer f = createColorTransformer((int)image.getWidth(), (int)image.getHeight(), borderWidth, Color.BLUE);
        Image transformedImage = LatentImage.from(image).transform(Color::brighter).transform(Color::grayscale).transform(f).toImage();

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