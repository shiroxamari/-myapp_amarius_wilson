package utils;

import java.util.Arrays;

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

    public ArrayList(List<E> otherList) {
        this(otherList.size());
        addAll(otherList);
    }


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

    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E item) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    // for item removal via index
    public E remove(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E removed = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removed;
    }

    @Override
    public boolean remove(E item) {
        return false;
    }

    @Override
    public boolean removeAll(List<E> otherList) {
        return false;
    }

    @Override
    public E set(int index, E item) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
