package chapter3.exercise08;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
    public Color apply(int x, int y, Color colorAthXY);

    public static ColorTransformer createColorTransformer(int imageWidth, int imageHeight, int borderWidth, Color newColor) {
        return (x, y, color) -> {
            if ( x < borderWidth || y < borderWidth
                    || x >= (imageWidth - borderWidth)
                    || y >= (imageHeight - borderWidth)) {
                return newColor;
            } else {
                return color;
            }
        };
    }
}
