package uy.edu.um.prog2.adt;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.exceptions.DatosIncorrectos;
import uy.edu.um.prog2.adt.exceptions.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {
    StackImpl stack = new StackImpl();


    @Test
    void push() {
        stack.push("hola");
        stack.push("mundo");
        stack.push("!");

        try {
            assertEquals("!", stack.get(2));
        } catch (DatosIncorrectos e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void pop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Remove value 2

        try {
            assertEquals(3,stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(2, stack.size());
        Assert.assertTrue(stack.contains(1));
        Assert.assertFalse(stack.contains(3));
        Assert.assertTrue(stack.contains(2));



        try {
            assertEquals(2,stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(1, stack.size());
        Assert.assertFalse(stack.contains(2));
        Assert.assertFalse(stack.contains(3));
        Assert.assertTrue(stack.contains(1));


        // Remove value 3 (last element)
        try {
            assertEquals(1,stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(0, stack.size());
        Assert.assertFalse(stack.contains(2));
        Assert.assertFalse(stack.contains(3));
        Assert.assertFalse(stack.contains(1));


    }

    @Test
    void peek() {
        assertEquals(null, stack.peek());

        // Caso 2: Lista con un elemento, se espera que el resultado sea el valor del elemento
        stack.push(5);

        //assertEquals(5, stack.peek());

        // Caso 3: Lista con varios elementos, se espera que el resultado sea el valor del último elemento
        stack.push(10);
        stack.push(15);
        assertEquals(15, stack.peek());

        // Verificar que el tamaño de la lista no ha cambiado
        assertEquals(3, stack.size());
    }

    @Test
    void size() {
        assertEquals(0, stack.size());
        stack.push("hola");
        assertEquals(1, stack.size());
    }

    @Test
    void get() {
        stack.push("hola");
        stack.push("mundo");
        try {
            assertEquals("mundo", stack.get(1));
        } catch (DatosIncorrectos e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void contains() {
        stack.push("hola");
        assertTrue(stack.contains("hola"));
    }
}