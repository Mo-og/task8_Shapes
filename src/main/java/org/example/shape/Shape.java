package org.example.shape;

import org.example.shape.interfaces.Named;

import java.awt.*;

public abstract class Shape implements Named {
    public abstract Point[] getPoints();

    @Override
    public String toString() {
        return "{" + getName() + "}";
    }

}
