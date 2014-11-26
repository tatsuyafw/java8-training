package chapter3.exercise05;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	public Color apply(int x, int y, Color colorAthXY);
}
