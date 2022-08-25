package org.example;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Rectangle extends Shape {
    private static final String SHAPE_NAME = "Rectangle";

    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;

    public Rectangle() {
        this(new Point(), new Point(0, 1), new Point(2, 1), new Point(2, 0));
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        Set<Point> set = new TreeSet<>(PointComparator.getInstance());
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        if (set.size() < 4) throw new IllegalArgumentException("Some points coincide");
        Iterator<Point> iterator = set.iterator();
        this.p1 = iterator.next();
        this.p2 = iterator.next();
        this.p3 = iterator.next();
        this.p4 = iterator.next();
    }

    @Override
    public String getName() {
        return SHAPE_NAME;
    }

    @Override
    protected void draw(boolean includeCoordsCentre) {
        super.draw(includeCoordsCentre, p1, p2, p3, p4);
    }

    @Override
    public String toString() {
        return "%s{(%d, %d); (%d, %d); (%d, %d); (%d, %d)}".formatted(SHAPE_NAME, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);
    }
}
