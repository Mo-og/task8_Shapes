package org.example;

import java.awt.*;

public class Circle extends Shape {
    private static final String SHAPE_NAME = "Circle";
    private final Point centre;
    private final double radius;

    public Circle() {
        this(new Point(), 1);
    }

    public Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    @Override
    protected void draw(boolean includeCoordsCentre) {
        Point left = ((Point) centre.clone());
        Point right = ((Point) centre.clone());
        Point top = ((Point) centre.clone());
        Point bottom = ((Point) centre.clone());

        left.translate((int) -radius, 0);
        right.translate((int) radius, 0);
        top.translate(0, (int) radius);
        bottom.translate(0, (int) -radius);

        super.draw(includeCoordsCentre, centre, left, right, top, bottom);
    }

    @Override
    public String getName() {
        return SHAPE_NAME;
    }

    @Override
    public String toString() {
        return "%s{c: (%d, %d); r: %.2g}".formatted(SHAPE_NAME, centre.x, centre.y, radius);
    }
}
