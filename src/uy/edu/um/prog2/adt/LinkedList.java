package uy.edu.um.prog2.adt;

public interface LinkedList<T> {

    void add(T value);

    T get(int position);

    boolean contains(T value);

    void remove(T value);

    int size();
}
