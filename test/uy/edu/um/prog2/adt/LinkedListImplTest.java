package uy.edu.um.prog2.adt;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.exceptions.DatosIncorrectos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LinkedListImplTest {
    LinkedListImpl linkedList = new LinkedListImpl();
    LinkedListImpl list = new LinkedListImpl();

    @Test
    void add() {
        linkedList.add("hola");
        linkedList.add("mundo");
        linkedList.add("!");
        try {
            assertEquals("!", linkedList.get(2));
        } catch (DatosIncorrectos e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void get() {
        linkedList.add("hola");
        linkedList.add("mundo");
        try {
            assertEquals("mundo", linkedList.get(1));
        } catch (DatosIncorrectos e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void contains() {
        linkedList.add("hola");
        assertTrue(linkedList.contains("hola"));
    }

    @Test
    void remove() {
        list.add(1);
        list.add(2);
        list.add(3);

        // Remove value 2
        list.remove(2);
        Assert.assertEquals(2, list.size());
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(2));
        Assert.assertTrue(list.contains(3));

        list.remove(1);
        Assert.assertEquals(1, list.size());
        Assert.assertFalse(list.contains(1));
        Assert.assertTrue(list.contains(3));

        // Remove value 3 (last element)
        list.remove(3);
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains(3));
    }

    @Test
    void size() {
        assertEquals(0, linkedList.size());
        linkedList.add("hola");
        assertEquals(1, linkedList.size());

    }
}