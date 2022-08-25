package org.example;

import java.awt.*;

public class ShapeTester {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Pentagon(), new Rectangle(), new Square(), new Triangle()};
        for (Shape shape : shapes) {
            System.out.print(shape + " -> ");
            shape.printName();
            shape.draw();
            shape.draw(true);
            System.out.println("-".repeat(62));
        }

        new Pentagon(new Point(-1, -1), new Point(1, -1), new Point(-2, 1), new Point(2, 1), new Point(0, 3))
                .draw(true);

    }
}