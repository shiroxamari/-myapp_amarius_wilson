package utils;

import java.util.Arrays;

// when I'm finished, this code should allow me to create and


public abstract class ArrayList<E> implements List<E> {
    private static final int STARTING_SPACE = 10;
    private E[] data;
    private int size;

    // starting constructor
    public ArrayList(){
        this(STARTING_SPACE);

    }
    @SuppressWarnings("unchecked")
    public ArrayList(int space){
        data = (E[]) new Object[space];
        size = 0;

    }
    public void ensureSpace(){
        if (size == data.length){
            if (data.length == Integer.MAX_VALUE){
                throw new OutOfMemoryError("cannot allocate more space for the list.");
            }
            int newSize = Math.min(data.length * 2, Integer.MAX_VALUE);
            data = Arrays.copyOf(data, data.length * 2);

        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }
        return result.append("]").toString();
    }

    public ArrayList(List<E> otherList) {
        this(otherList.size());
        addAll(otherList);
    }
    // method to make sure there is enough space in the array list to add more items

    // to add items at certain indexes
    @Override
    public void add(int index, E item){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureSpace();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }


    @Override
    public boolean add(E item){
        ensureSpace();
        data[size++] = item;
        return true;
    }

    // to add all from another list
    @Override
    public boolean addAll(List<E> otherList){
        if (otherList == null) {
            throw new NullPointerException("Provided list cannot be null");
        }
        for(int i = 0; i < otherList.size(); i++){
            add(otherList.get(i));

        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            data[i] = null;
        }
        data = (E[]) new Object[STARTING_SPACE];
        size = 0;


    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return data[index];
    }
    // gives me the index of whichever item
    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++){
            if (item == null ? data[i] == null : data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    // for item removal via index
    public E remove(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E removedItem = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removedItem;
    }
    // to remove first iteration of an item
    @Override
    public E removeFirst(E item) {
        int index = indexOf(item);
        if (index == -1) return null;
        return remove(index);
    }

    public boolean removeAll(List<E> otherList){

    }



    public E set(int index, E item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E prevItem = data[index];
        data[index] = item;
        return prevItem;
    }


    public int size() {
        return size;
    }

}
