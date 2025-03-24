package utils;

import java.util.Arrays;
import java.util.Objects;

public abstract class ArrayList<E> implements List<E> {
    private static final int STARTING_SPACE = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    private E[] data;
    private int size;

    public ArrayList() {
        this(STARTING_SPACE);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        data = (E[]) new Object[initialCapacity];
        size = 0;
    }

    public ArrayList(List<E> otherList) {
        this(otherList.size());
        addAll(otherList);
    }

    public <E> ArrayList(java.util.List<E> otherList) {
    }

    // Renamed and updated logic for capacity handling
    protected void ensureCapacity() {
        if (size == data.length) {
            if (data.length == MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError("Cannot allocate more space for the list.");
            }
            int expandedCapacity = Math.min(data.length * 2, MAX_ARRAY_SIZE);
            data = Arrays.copyOf(data, expandedCapacity);
        }
    }

    // Extracted index validation logic to its own method
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }

    @Override
    public boolean add(E item) {
        ensureCapacity();
        data[size++] = item;
        return true;
    }

    @Override
    public boolean addAll(List<E> otherList) {
        if (otherList == null) {
            throw new NullPointerException("Provided list cannot be null");
        }
        for (int i = 0; i < otherList.size(); i++) { // Simplified using enhanced for-loop
            add(otherList.get(i));

        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null); // Clear only valid elements
        data = Arrays.copyOf(data, STARTING_SPACE); // Reset capacity to initial
        size = 0;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    @Override
    public E get(int index) {
        validateIndex(index); // Extracted for better reuse
        return data[index];
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], item)) { // Simplified null check
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean remove(E item) {
        int index = indexOf(item); // Find the index of the first occurrence
        if (index >= 0) {
            remove(index); // Use the existing `remove(int index)` method
            return true;
        }
        return false; // Return false if the item is not found
    }

    @Override
    public E remove(int index) {
        validateIndex(index); // Centralized index validation
        E removedItem = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // Prevent memory leak
        return removedItem;
    }

    @Override
    public boolean removeAll(List<E> otherList) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (otherList.contains(data[i])) {
                remove(i);
                i--; // Adjust index after removal
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public E set(int index, E item) {
        validateIndex(index); // Extracted for efficiency and cleaner code
        E prevItem = data[index];
        data[index] = item;
        return prevItem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.append("]").toString();
    }
}