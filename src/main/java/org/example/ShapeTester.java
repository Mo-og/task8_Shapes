package org.example;

import org.example.drawing.ToConsoleDrawer;
import org.example.drawing.interfaces.Drawer;
import org.example.shape.Rectangle;
import org.example.shape.Shape;
import org.example.shape.*;

import java.awt.*;

public class ShapeTester {
    public static void main(String[] args) {
        Drawer drawer = new ToConsoleDrawer();
        Shape[] shapes = {new Circle(), new Pentagon(), new Rectangle(), new Square(), new Triangle()};
        for (Shape shape : shapes) {
            System.out.print(shape + " -> ");
            shape.printName();

            drawer.draw(shape);

            printDivider("=");
            printDivider("=");
        }

        //Shape with no Point(0; 0) as its part
        System.out.println("Custom");
        printDivider(":");
        Shape[] shapes2 = {
                new Pentagon(
                        new Point(-1, -1),
                        new Point(1, -1),
                        new Point(-2, 1),
                        new Point(2, 1),
                        new Point(0, 3)
                ),
                new Triangle(
                        new Point(-1, -1),
                        new Point(-1, 4),
                        new Point(2, -1)
                ),
                new Circle(
                        new Point(3, 4),
                        4
                ),
                new Circle(
                        new Point(8, -4),
                        14
                ),
                new Square(
                        new Point(0, -2),
                        new Point(-1, 1),
                        new Point(2, 2),
                        new Point(3, -1)
                ),
                new Square(
                        new Point(-1, 1),
                        new Point(-1, -2),
                        new Point(2, 1),
                        new Point(2, -2)
                )
        };
        for (Shape shape : shapes2) {
            drawer.draw(shape, true);
            printDivider("\"");
        }
    }

    private static void printDivider(String x) {
        System.out.println(x.repeat(62));
    }
}