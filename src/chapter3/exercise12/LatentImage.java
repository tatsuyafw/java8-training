package chapter3.exercise12;

import static chapter3.exercise12.ColorTransformer.changeUnaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
    private Image in;
    private List<ColorTransformer> pendingOperations;

    private LatentImage(Image in) {
        this.in = in;
        this.pendingOperations = new ArrayList<ColorTransformer>();
    }

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(changeUnaryOperator(f));
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f : pendingOperations) {
                    c = f.apply(x, y, c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }
}
