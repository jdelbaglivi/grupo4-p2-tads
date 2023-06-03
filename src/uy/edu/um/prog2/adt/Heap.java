package uy.edu.um.prog2.adt;

public interface Heap<K extends Comparable<K>, T> {

    void insert(K key, T value);

    void delete(K key);

    T peek();

}
