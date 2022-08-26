package org.example.drawing;

import java.awt.*;

public class CustomPoint extends Point {
    public final String drawing;

    public CustomPoint(Point point, String drawing) {
        super(point);
        this.drawing = drawing;
    }

    public CustomPoint(int x, int y, String drawing) {
        super(x, y);
        this.drawing = drawing;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
