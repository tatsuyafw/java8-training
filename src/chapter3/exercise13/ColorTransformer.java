package chapter3.exercise13;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
    public Color apply(int x, int y, Color colorAthXY);

    public static ColorTransformer compose(ColorTransformer op1, ColorTransformer op2) {
        return (x, y, color) -> {
            Color op1ResultColor = op1.apply(x, y, color);
            return op2.apply(x, y, op1ResultColor);
        };
    }

    public static ColorTransformer changeUnaryOperator(UnaryOperator<Color> op) {
        return (x, y, color) -> op.apply(color);
    }

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
