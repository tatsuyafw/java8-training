package chapter3.exercise11;

import static chapter3.exercise11.ColorTransformer.changeUnaryOperator;
import static chapter3.exercise11.ColorTransformer.compose;
import static chapter3.exercise11.ColorTransformer.createColorTransformer;
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
        ColorTransformer f1 = changeUnaryOperator(Color::brighter);
        ColorTransformer f2 = createColorTransformer((int)image.getWidth(), (int)image.getHeight(), borderWidth, Color.BLUE);
        Image transformedImage = Transformer.transform(image, compose(f1, f2));

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
