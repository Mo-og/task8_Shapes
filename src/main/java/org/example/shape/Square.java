package org.example.shape;

import java.awt.*;
import java.util.Arrays;

public class Square extends Rectangle {
    private static final String SHAPE_NAME = "Square";

    public Square() {
        this(new Point(), new Point(0, 1), new Point(1, 1), new Point(1, 0));
    }

    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
        if (!isSquareValid()) throw new IllegalArgumentException("Points do not make a square");
    }

    private boolean isSquareValid() {
        double[] sides = {p1.distanceSq(p2), p1.distanceSq(p3), p1.distanceSq(p4), p2.distanceSq(p3), p2.distanceSq(p4), p3.distanceSq(p4)};
        Arrays.sort(sides);

        return sides[0] == sides[1] && sides[0] == sides[2] && sides[0] == sides[3];
    }

    @Override
    public String getName() {
        return SHAPE_NAME;
    }

    @Override
    public String toString() {
        return "%s{(%d, %d); (%d, %d); (%d, %d); (%d, %d)}".formatted(SHAPE_NAME, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);
    }
}
