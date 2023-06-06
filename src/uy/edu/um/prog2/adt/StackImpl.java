package uy.edu.um.prog2.adt;

import uy.edu.um.prog2.adt.exceptions.DatosIncorrectos;
import uy.edu.um.prog2.adt.exceptions.EmptyStackException;

public class StackImpl<T> implements Stack<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public StackImpl() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public void push(T value) {

        if (value != null) {

            Node<T> newNode = new Node<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = newNode;


            } else { // en caso de no ser vacia se agrega al final
                Node<T> curr = this.first;
                while (curr.getNext() != null) {
                    curr = curr.getNext();
                }
                curr.setNext(newNode);
            }
            this.size++;

        } else {
            // si el elemento es vacio se ignora
        }
    }


    @Override
    public T pop() throws EmptyStackException {
        if (this.last == null) {
            throw new EmptyStackException();
        }
        Node<T> beforeSearchValue = null;
        Node<T> searchValue = this.first;

        T valueToRemove = null;
        if (this.size == 1) {
            first = null;
            last = null;
        } else {


            valueToRemove = this.last.getValue();

            // Busco el elemento a eliminar teniendo en cuenta mantener una referencia al elemento anterior
            while (searchValue != null && !searchValue.getValue().equals(valueToRemove)) {

                beforeSearchValue = searchValue;
                searchValue = searchValue.getNext();

            }

            if (searchValue != null) { // si encontre el elemento a eliminar

                //Verifico si es el primer valor (caso borde) y no es el último
                if (searchValue == this.first && searchValue.getNext()!=null) {

                    Node<T> aux = this.first;
                    this.first = this.first.getNext(); // salteo el primero

                    aux.setNext(null); // quito referencia del elemento eliminado al siguiente.

                    // Verifico si es el primer valor (caso borde) y no el primero
                } else if (searchValue.getNext() == null && searchValue != this.first) {

                    beforeSearchValue.setNext(null);


                    // Sí es el primer valor y el último (lista de un solo valor)
                } else if (searchValue.getNext() == null && searchValue == this.first) {

                    this.first = null;

                } else { // resto de los casos

                    beforeSearchValue.setNext(searchValue.getNext());
                    searchValue.setNext(null);
                }

            } else {
                // Si no es encuentra el valor a eliminar no se realiza nada
            }


        }
        this.size--;
        return valueToRemove;

    }


    @Override
    public T peek() {
        T valueToReturn = null;

        if (this.last != null) {
            valueToReturn = this.last.getValue();
        }

        return valueToReturn;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int position) throws DatosIncorrectos {
        if (position < 0 || position >= this.size) {
            throw new DatosIncorrectos();
        }

        Node<T> aux = this.first;

        // Se busca el nodo que corresponde con la posición
        for (int i = 0; i < position; i++) {
            aux = aux.getNext();
        }


        // Se retorna el valor del nodo en la posición especificada
        return aux.getValue();

    }


}
