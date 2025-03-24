package utils;

public interface List<E> {
    boolean add(E item);
    void add(int index, E item);
    boolean addAll(List<E> otherList);
    void clear();
    boolean contains(E item);
    E get(int index);
    int indexOf(E item);
    boolean isEmpty();
    E remove(int index);
    boolean remove(E item);
    boolean removeAll(List<E> otherList);
    E set(int index, E item);
    int size();


    // Default methods with some basic implementations
    default void addFirst(E item) {
        add(0, item);
    }

    default E getFirst() {
        return get(0);
    }

    default E getLast() {
        return get(size() - 1);
    }

    default E removeFirst(E item) {
        return remove(0);
    }

    default E removeLast() {
        return remove(size() - 1);
    }
}
