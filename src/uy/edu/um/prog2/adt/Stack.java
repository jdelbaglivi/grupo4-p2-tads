package uy.edu.um.prog2.adt;

import uy.edu.um.prog2.adt.exceptions.EmptyStackException;

public interface Stack<T> {
    void push(T value);

    T pop() throws EmptyStackException;

    T peek();

    int size();

    T get(int position);
}
