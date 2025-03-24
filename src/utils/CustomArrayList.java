package utils;

import java.util.List;

public abstract class CustomArrayList<E> extends ArrayList<E> {

    // Default constructor directly delegates to the parent class
    public CustomArrayList() {
        super();
    }

    // Constructor with initial capacity
    public CustomArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    // Constructor accepting another list
    public CustomArrayList(List<E> otherList) {
        super(otherList);
    }
}