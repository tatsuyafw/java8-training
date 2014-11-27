package chapter3.exercise13;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ImageTransformer {
    public Color apply(Image in, int x, int y, Color colorAthXY);
}
