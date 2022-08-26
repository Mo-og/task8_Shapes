package org.example.drawing.interfaces;

import org.example.shape.Shape;

public interface Drawer {
    default void draw(Shape shape) {
        draw(shape, false);
    }

    void draw(Shape shape, boolean includeCoordsCentre);
}
