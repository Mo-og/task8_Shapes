package org.example.shape.interfaces;

public interface Named {
    String getName();

    default void printName() {
        System.out.println(getName());
    }
}
