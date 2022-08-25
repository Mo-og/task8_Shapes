package org.example;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Triangle extends Shape {
    private static final String SHAPE_NAME = "Triangle";
    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle() {
        this(new Point(), new Point(5, 9), new Point(10, 0));
    }

    public Triangle(Point p1, Point p2, Point p3) {
        Set<Point> set = new TreeSet<>(PointComparator.getInstance());
        set.add(p1);
        set.add(p2);
        set.add(p3);
        if (set.size() < 3) throw new IllegalArgumentException("Some points coincide");
        Iterator<Point> iterator = set.iterator();
        this.p1 = iterator.next();
        this.p2 = iterator.next();
        this.p3 = iterator.next();
        if (!isValid()) throw new IllegalArgumentException("Points do not make a triangle");
    }

    private boolean isValid() {
        double ab = p1.distance(p2);
        double bc = p2.distance(p3);
        double ac = p1.distance(p3);
        return (ab < ac + bc) && (ac < ab + bc) && (bc < ac + ab);
    }

    @Override
    public String getName() {
        return SHAPE_NAME;
    }

    @Override
    protected void draw(boolean includeCoordsCentre) {
        super.draw(includeCoordsCentre, p1, p2, p3);
    }

    @Override
    public String toString() {
        return "%s{(%d, %d); (%d, %d); (%d, %d)}".formatted(SHAPE_NAME, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
    }
}
