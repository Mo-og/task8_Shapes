package org.example;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Pentagon extends Shape {
    private static final String SHAPE_NAME = "Pentagon";

    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;
    private final Point p5;

    public Pentagon() {
        this(new Point(), new Point(2, 2), new Point(4, 0), new Point(3, -2), new Point(1, -2));
    }

    public Pentagon(Point p1, Point p2, Point p3, Point p4, Point p5) {
        //sorting is for easier comparing of pentagons
        Set<Point> set = new TreeSet<>(PointComparator.getInstance());
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        if (set.size() < 5) throw new IllegalArgumentException("Some points coincide");
        Iterator<Point> iterator = set.iterator();
        this.p1 = iterator.next();
        this.p2 = iterator.next();
        this.p3 = iterator.next();
        this.p4 = iterator.next();
        this.p5 = iterator.next();
    }

    @Override
    public String getName() {
        return SHAPE_NAME;
    }

    /**
     * @param includeCoordsCentre includes <code>Point(0;0)</code> in the resulting drawing represented by <code>⊙<code/> symbol if <code>true</code>
     */
    @Override
    protected void draw(boolean includeCoordsCentre) {
        super.draw(includeCoordsCentre, p1, p2, p3, p4, p5);
    }

    @Override
    public String toString() {
        return "%s{(%d, %d); (%d, %d); (%d, %d); (%d, %d); (%d, %d)}".formatted(SHAPE_NAME, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y, p5.x, p5.y);
    }
}
