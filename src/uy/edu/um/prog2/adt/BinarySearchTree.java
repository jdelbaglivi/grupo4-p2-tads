package uy.edu.um.prog2.adt;

public interface BinarySearchTree<K extends Comparable<K>, T> {

    boolean find(T element);

    void insert(T element);

    void delete(T element);

    T findMax();

    T findMin();

}
