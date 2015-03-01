package chapter8.exercise06;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

import org.junit.Before;
import org.junit.Test;

public class MyComparatorTest {
    private Point2D pointA, pointB, pointC, pointD;
    private Rectangle2D recA, recB, recC, recD;

    @Before
    public void setup() {
        pointA = new Point2D(0, 0);
        pointB = new Point2D(1, 0);
        pointC = new Point2D(0, 0);
        pointD = new Point2D(0, -1);

        recA = new Rectangle2D(0, 0, 1, 1);
        recB = new Rectangle2D(0, 0, 2, 1);
        recC = new Rectangle2D(0, 0, 1, 1);
        recD = new Rectangle2D(-1, -1, 1, 1);
    }

    @Test
    public void testComparatorForPoint2D() {
        Comparator<Point2D> comparator = MyComparator.comparatorForPoint2D();

        assertThat(comparator.compare(pointA, pointB), is(-1));
        assertThat(comparator.compare(pointB, pointA), is(1));

        assertThat(comparator.compare(pointA, pointC), is(0));
        assertThat(comparator.compare(pointC, pointA), is(0));

        assertThat(comparator.compare(pointA, pointD), is(1));
        assertThat(comparator.compare(pointD, pointA), is(-1));
    }

    @Test
    public void testComparatorForRectangle2D() {
        Comparator<Rectangle2D> comparator = MyComparator.comparatorForRectangle2D();

        assertThat(comparator.compare(recA, recB), is(-1));
        assertThat(comparator.compare(recB, recA), is(1));

        assertThat(comparator.compare(recA, recC), is(0));
        assertThat(comparator.compare(recC, recA), is(0));

        assertThat(comparator.compare(recA, recD), is(1));
        assertThat(comparator.compare(recD, recA), is(-1));
    }

}
