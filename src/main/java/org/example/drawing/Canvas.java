package org.example.drawing;

import java.awt.*;

class Canvas {
    public static final String CENTER_DRAWING = "⊙";
    private static final String AGGREGATE = "   ";
    private static final String POINT_DRAWING = "(•)";
    private final Point[] points;
    private StringBuilder[] builders;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private boolean includeCoordsCentre;

    /**
     * @param includeCoordsCentre includes <code>Point(0;0)</code> in the resulting drawing represented by <code>⊙<code/> symbol if <code>true</code>
     */
    Canvas(boolean includeCoordsCentre, Point... points) {
        this.points = points;
        this.includeCoordsCentre = includeCoordsCentre;

        reset();
    }

    /**
     * Clears the canvas and resets its size according to points array.
     */
    public void reset() {
        if (includeCoordsCentre || points.length == 0) {
            minX = 0;
            maxX = 0;
            minY = 0;
            maxY = 0;
        } else {
            minX = points[0].x;
            maxX = points[0].x;
            minY = points[0].y;
            maxY = points[0].y;
        }

        setCoordsRanges();

        setBuilders();
    }

    private void setCoordsRanges() {
        for (Point point : points) {
            if (point.x > maxX) maxX = point.x;
            if (point.y > maxY) maxY = point.y;
            if (point.x < minX) minX = point.x;
            if (point.y < minY) minY = point.y;
        }
    }

    private void drawCoordsCentre() {
        int row = maxY;
        int col = (-minX) * AGGREGATE.length();
        builders[row].replace(col + AGGREGATE.length() / 2, col + AGGREGATE.length() / 2 + CENTER_DRAWING.length(), CENTER_DRAWING);
    }

    private void setBuilders() {
        int rows = maxY - minY + 1;
        int columns = maxX - minX + 1;
        StringBuilder[] canvas = new StringBuilder[rows];
        String aggregate = AGGREGATE.repeat(columns) + "\n";
        for (int i = 0; i < canvas.length; i++) {
            canvas[i] = new StringBuilder(aggregate);
        }
        builders = canvas;
    }

    /**
     * Adds all points to the canvas
     */
    public void fill() {
        for (Point point : points) {
            drawPoint(point);
        }
    }

    private void drawPoint(Point p) {
        int row = maxY - p.y;
        int col = (p.x - minX) * AGGREGATE.length();
        if (p instanceof CustomPoint custom) {
            //length check and fix for `custom.drawing.length < AGGREGATE.length`
            int colInd = col + (AGGREGATE.length() - custom.drawing.length()) / 2;
            builders[row].replace(colInd, colInd + custom.drawing.length(), custom.drawing);
        } else
            builders[row].replace(col, col + AGGREGATE.length(), POINT_DRAWING);
    }

    @Override
    public String toString() {
        if (includeCoordsCentre) {
            drawCoordsCentre();
            includeCoordsCentre = false;
        }
        StringBuilder sb = builders[0];
        for (int i = 1; i < builders.length; i++) {
            sb.append(builders[i]);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
