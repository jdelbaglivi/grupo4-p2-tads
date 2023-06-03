package uy.edu.um.prog2.adt;

public interface BinarySearchTree<K extends Comparable<K>, T> {

    boolean find(K key);

    void insert(K key, T value);

    void delete(K key);

    T findMax();

    T findMin();

}
