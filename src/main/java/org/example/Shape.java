package org.example;

import java.awt.*;

public abstract class Shape {


    public abstract String getName();

    public void printName() {
        System.out.println(getName());
    }

    @Override
    public String toString() {
        return "{" + getName() + "}";
    }

    protected void draw() {
        draw(false);
    }

    protected abstract void draw(boolean includeCoordsCentre);

    protected void draw(boolean includeCoordsCentre, Point... points) {
        if (points.length == 0) return;

        Canvas canvas = new Canvas(includeCoordsCentre, points);

        for (Point point : points) {
            canvas.drawPoint(point);
        }

        System.out.println(canvas);
    }

    private static class Canvas {
        private static final String AGGREGATE = "   ";
        private static final String POINT_DRAWING = "(•)";
        public static final String CENTER_DRAWING = "⊙";
        private StringBuilder[] builders;
        private int maxX;
        private int maxY;
        private int minX;
        private int minY;
        private final Point[] points;
        private boolean includeCoordsCentre;

        public Canvas(boolean includeCoordsCentre, Point... points) {
            this.points = points;
            this.includeCoordsCentre = includeCoordsCentre;

            if (includeCoordsCentre) {
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

        public void drawCoordsCentre() {
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

        public void drawPoint(Point p) {
            int row = maxY - p.y;
            int col = (p.x - minX) * AGGREGATE.length();
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
            return sb.toString();
        }
    }
}
