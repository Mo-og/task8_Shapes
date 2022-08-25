package org.example;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        CustomPoint left = new CustomPoint((Point) centre.clone(), " ( ");
        CustomPoint right = new CustomPoint((Point) centre.clone(), " ) ");
        CustomPoint top = new CustomPoint((Point) centre.clone(), " ^ ");
        CustomPoint bottom = new CustomPoint((Point) centre.clone(), " _ ");

        left.translate((int) -radius, 0);
        right.translate((int) radius, 0);
        top.translate(0, (int) radius);
        bottom.translate(0, (int) -radius);

        Set<Point> set = new HashSet<>(List.of(centre, left, right, top, bottom));
        //draw horizontally
        for (int i = left.x + 1; i < right.x; i++) {
            int y = getCoords(i, centre.x, centre.y);
            set.add(new CustomPoint(i, y, i < centre.x ? " / " : " \\ "));
            set.add(new CustomPoint(i, -y + centre.y * 2, i < centre.x ? " ‛ " : " ‘ "));
        }

        //draw vertically
        for (int i = bottom.y + 1; i < top.y; i++) {
            int x = getCoords(i, centre.y, centre.x);
            set.add(new CustomPoint(x, i, i < centre.y ? " / " : " ‛ "));
            set.add(new CustomPoint(-x + centre.x * 2, i, i < centre.y ? " ‛ " : " ‘ "));
        }

        super.draw(includeCoordsCentre, set.toArray(new Point[0]));
    }

    private int getCoords(int i, int fromBrackets, int subtrahend) {
        return (int) Math.round(Math.sqrt((radius * radius) - Math.pow((double) i - fromBrackets, 2))) + subtrahend;
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
