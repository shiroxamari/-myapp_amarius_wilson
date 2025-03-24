package utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * A custom implementation of a dynamic array-based list.
 * This abstract class provides a partial implementation of the {@code List} interface
 * and supports basic operations such as adding, removing, retrieving, and searching elements.
 * <p>
 * This class uses an underlying array to store elements and dynamically expands its capacity
 * when required to accommodate additional elements.
 * Subclasses must implement any remaining abstract methods from the {@code List} interface.
 *
 * @param <E> the type of elements stored in this list
 */


public abstract class ArrayList<E> implements List<E>, Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * The default initial capacity of the list when no capacity is specified.
     */

    private static final int STARTING_SPACE = 10;
    /**
     * The maximum size of the internal array. Exceeding this size will throw
     * an {@code OutOfMemoryError}.
     */

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;
    /**
     * The internal array used to store the elements of the list.
     */


    private E[] data;
    private int size;




    /**
     * Constructs a new {@code ArrayList} with a default initial capacity.
     */

    public ArrayList() {
        this(STARTING_SPACE);
    }
    /**
     * Constructs a new {@code ArrayList} with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the array list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */

    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        data = (E[]) new Object[initialCapacity];
        size = 0;
    }

    /**
     * Constructs a new {@code ArrayList} by copying the elements of the specified list.
     *
     * @param otherList the list whose elements are to be copied
     * @throws NullPointerException if the specified list is {@code null}
     */
    public ArrayList(java.util.List<? extends E> otherList) {
        this(otherList.size());
        for (E item : otherList){
            add(item);
        }
    }






    /**
     * Ensures that the internal array has sufficient capacity to store additional elements.
     * If the array is full, its capacity is doubled.
     * <p>
     * Throws an {@code OutOfMemoryError} if the array reaches its maximum allowed size.
     * renamed from ensureSpace for better handling
     */

    protected void ensureCapacity() {
        if (size == data.length) {
            if (data.length == MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError("Cannot allocate more space for the list.");
            }
            int expandedCapacity = Math.min(data.length * 2, MAX_ARRAY_SIZE);
            data = Arrays.copyOf(data, expandedCapacity);
        }
    }


    /**
     * Validates the specified index to ensure it is within range.
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }




    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts any existing elements at or beyond the position to the right (adds one to their indices).
     *
     * @param index the index at which the specified element is to be inserted
     * @param item  the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (less than 0 or greater than size)
     */

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }




    /**
     * Appends the specified element to the end of this list.
     *
     * @param item the element to be appended
     * @return {@code true} (as specified by the {@code List} interface)
     */
    @Override
    public boolean add(E item) {
        ensureCapacity();
        data[size++] = item;
        return true;
    }




    /**
     * Appends all elements of the specified list to the end of this list.
     * The list is expanded if necessary.
     *
     * @param otherList the list containing elements to be added
     * @return {@code true} if the list was modified as a result of the operation
     * @throws NullPointerException if the specified list is {@code null}
     */

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
    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null); // Clear only valid elements
        data = Arrays.copyOf(data, STARTING_SPACE); // Reset capacity to initial
        size = 0;
    }




    /**
     * Checks if the list contains the specified element.
     *
     * @param item the element to search for
     * @return {@code true} if the element exists in the list; {@code false} otherwise
     */
    @Override
    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }




    /**
     * Returns the element at the specified position in the list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range (less than 0 or greater than/equal to size)
     */
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



    /**
     * Returns {@code true} if the list contains no elements.
     *
     * @return {@code true} if the list is empty; {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Removes the element at the specified position in the list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range (less than 0 or greater than/equal to size)
     */

    public boolean remove() {
        return remove(null);
    }

    /**
     * Removes the element at the specified position in the list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param item the index of the element to be removed
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range (less than 0 or greater than/equal to size)
     */

    @Override
    public boolean remove(E item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], item)) { // Handles null safely
                remove(i);
                return true;
            }
        }
        return false;
    }



    /**
     * Removes all the elements in this list that are also present in the specified list.
     *
     * @param otherList the list containing elements to be removed
     * @return {@code true} if any elements were removed; {@code false} otherwise
     */
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


    /**
     * Returns the string representation of this list.
     *
     * @return a string representation of the list
     */
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

    public void sort(Comparator<? super E> comparator){
        Arrays.sort(data, 0, size, comparator);
    }

    public void reverse(){
        for (int i = 0; i < size / 2; i++){
            E temp = data[i];
            data[i] = data[size - 1 - i];
            data[size - 1 - i] = temp;

        }

    }
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid subList range.");
        }
        // Create a sublist backed by the original array
        ArrayList<E> subList = new ArrayList<E>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(data[i]);
        }
        return subList;
    }

}