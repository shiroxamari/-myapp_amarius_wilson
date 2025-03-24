package utils;

import java.util.Arrays;

// when I'm finished, this code should allow me to create and


public class ArrayList<E> implements List<E> {
    private static final int STARTING_SPACE = 10;
    private E[] data;
    private int size;

    // starting constructor
    public ArrayList(){
        this(STARTING_SPACE);

    }

    public ArrayList(int space){
        data = (E[]) new Object[space];
        size = 0;

    }
    private void ensureSpace(){
        if (size == data.length){
            data = Arrays.copyOf(data, data.length * 2);

        }
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
        for(int i = 0; i < otherList.size(); i++){
            add(otherList.get(i));

        }
        return true;
    }

    @Override
    public void clear() {
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
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
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
    public boolean remove(E item) {
        int index = indexOf(item);
        if (index == -1) return false;
        remove(index);
        return true;
    }


    @Override
    public E set(int index, E item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E prevItem = data[index];
        data[index] = item;
        return prevItem;
    }

    @Override
    public int size() {
        return size;
    }

}
