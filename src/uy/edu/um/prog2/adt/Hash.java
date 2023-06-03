package uy.edu.um.prog2.adt;

public interface Hash<K, T> {

    void put(K key, T value);

    T get(K key);

    void remove(K key);

    int size();

}
