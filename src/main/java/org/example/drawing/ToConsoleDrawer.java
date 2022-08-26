package org.example.drawing;

import org.example.drawing.interfaces.Drawer;
import org.example.shape.Shape;

import java.awt.*;

public class ToConsoleDrawer implements Drawer {
    public void draw(Shape shape, boolean includeCoordsCentre) {
        Point[] points = shape.getPoints();
        if (points.length == 0) return;

        Canvas canvas = new Canvas(includeCoordsCentre, points);

        canvas.fill();

        System.out.println(canvas);
    }
}
