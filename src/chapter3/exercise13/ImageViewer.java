package chapter3.exercise13;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        ImageTransformer gradation = (in, x, y, color) -> {
            List<Color> adjacentColors = new ArrayList<Color>();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    Optional<Color> op = getColor(in, x + dx, y + dy);
                    op.ifPresent((c) -> adjacentColors.add(c));
                }
            }
            double red = color.getRed();
            double green = color.getGreen();
            double blue = color.getBlue();
            for (Color c : adjacentColors) {
                red += c.getRed();
                green += c.getGreen();
                blue += c.getBlue();
            }
            int count = 1 + adjacentColors.size();
            red /= count; green /= count; blue /= count;
            return Color.rgb((int)(red * 255), (int)(green * 255), (int)(blue * 255));
        };
        Image transformedImage = LatentImage.from(image)
                .transform(Color::grayscale)
                .transform(Color::brighter)
                .strictTransform(gradation)
                .toImage();

        ImageView iv = new ImageView(transformedImage);
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(iv);
        stage.setScene(scene);
        stage.show();
    }

    private static Optional<Color> getColor(Image in, int x, int y) {
        int width = (int) in.getWidth();;
        int height = (int) in.getHeight();
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return Optional.empty();
        } else {
            return Optional.of(in.getPixelReader().getColor(x, y));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
