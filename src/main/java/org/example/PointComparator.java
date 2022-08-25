package org.example;

import java.awt.*;
import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    private static final PointComparator instance = new PointComparator();

    private PointComparator() {}

    public static PointComparator getInstance() {
        return instance;
    }

    @Override
    public int compare(Point o1, Point o2) {
        return o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x;
    }
}
