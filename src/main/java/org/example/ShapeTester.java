package org.example;

import java.awt.*;

public class ShapeTester {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Pentagon(), new Rectangle(), new Square(), new Triangle()};
        for (Shape shape : shapes) {
            System.out.print(shape + " -> ");
            shape.printName();

            shape.draw();
            printDivider("-");
            shape.draw(true);

            printDivider("=");
            printDivider("=");
        }

        //Shape with no Point(0; 0) as its part
        System.out.println("Custom");
        printDivider(":");
        new Pentagon(
                new Point(-1, -1),
                new Point(1, -1),
                new Point(-2, 1),
                new Point(2, 1),
                new Point(0, 3)
        ).draw(true);
        printDivider("=");

        new Triangle(
                new Point(-1, -1),
                new Point(-1, 4),
                new Point(2, -1)
        ).draw(true);
        printDivider("=");

        new Circle(
                new Point(3, 4),
                4
        ).draw(true);
        printDivider("=");

        new Circle(
                new Point(8, -4),
                14
        ).draw(true);
        printDivider("=");

    }

    private static void printDivider(String x) {
        System.out.println(x.repeat(62));
    }
}