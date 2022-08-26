package org.example.shape.interfaces;

import java.awt.*;

public interface Quadrangle {
    Point getP1();

    Point getP2();

    Point getP3();

    Point getP4();

    default Point[] getPoints() {
        return new Point[]{getP1(), getP2(), getP3(), getP4()};
    }

}
