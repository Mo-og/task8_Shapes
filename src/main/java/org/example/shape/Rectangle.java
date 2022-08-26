package org.example.shape;

import org.example.drawing.util.PointComparator;
import org.example.shape.interfaces.Quadrangle;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Rectangle extends Shape implements Quadrangle {
    private static final String SHAPE_NAME = "Rectangle";

    protected Point p1;
    protected Point p2;
    protected Point p3;
    protected Point p4;

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
        if (!isValid()) throw new IllegalArgumentException("Points do not make a rectangle");
    }

    private boolean isValid() {
        //2 pairs of sides and both diagonals (in arbitrary order) must be equal
        double[] sides = {p1.distanceSq(p2),
                p1.distanceSq(p3),
                p1.distanceSq(p4),
                p2.distanceSq(p3),
                p2.distanceSq(p4),
                p3.distanceSq(p4)};
        Arrays.sort(sides);
        //sides[0-3] are sides lengths; sides[4-5] are diagonals
        if (sides[0] != sides[1]) return false;
        if (sides[2] != sides[3]) return false;
        return sides[4] == sides[5];
    }

    @Override
    public String getName() {
        return SHAPE_NAME;
    }

    @Override
    public Point[] getPoints() {
        return Quadrangle.super.getPoints();
    }

    @Override
    public String toString() {
        return "%s{(%d, %d); (%d, %d); (%d, %d); (%d, %d)}".formatted(SHAPE_NAME, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }
}
