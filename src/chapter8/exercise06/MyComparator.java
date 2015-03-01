package chapter8.exercise06;

import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class MyComparator {
    public static void main(String[] args) {
        Comparator<Point2D> comparatorPoint2D = comparatorForPoint2D();
        Point2D pointA = new Point2D(0, 0);
        Point2D pointB = new Point2D(1, 0);
        System.out.println("Comparing pointA and pointB: " + comparatorPoint2D.compare(pointA,  pointB));

        Comparator<Rectangle2D> comparatorRectangle2D = comparatorForRectangle2D();
        Rectangle2D recA = new Rectangle2D(0, 0, 1, 1);
        Rectangle2D recB = new Rectangle2D(0, 0, 2, 1);
        System.out.println("Comparing recA and recB: " + comparatorRectangle2D.compare(recA,  recB));
    }

    /**
     * javafx.geometry.Point2D 向けの全順序 Comparator を返す
     */
    public static Comparator<Point2D> comparatorForPoint2D() {
        return Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY);
    }

    /**
     * javafx.geometry.Rectangle2D 向けの全順序 Comparator を返す
     */
    public static Comparator<Rectangle2D> comparatorForRectangle2D() {
        return Comparator.comparing(Rectangle2D::getMinX).thenComparing(Rectangle2D::getMinY)
                .thenComparing(Rectangle2D::getMaxX).thenComparing(Rectangle2D::getMaxY);
    }
}


