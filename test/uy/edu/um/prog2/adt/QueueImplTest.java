package uy.edu.um.prog2.adt;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.exceptions.DatosIncorrectos;
import uy.edu.um.prog2.adt.exceptions.EmptyQueueException;
import uy.edu.um.prog2.adt.exceptions.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {
    QueueImpl queue = new QueueImpl();

    @Test
    void enqueue() {
        queue.enqueue("hola");
        queue.enqueue("mundo");
        queue.enqueue("!");
        try {
            assertEquals("hola", queue.get(2));
        } catch (DatosIncorrectos e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void dequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Remove value 2

        try {
            assertEquals(1,queue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(2, queue.size());
        Assert.assertTrue(queue.contains(3));
        Assert.assertFalse(queue.contains(1));
        Assert.assertTrue(queue.contains(2));



        try {
            assertEquals(2,queue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.contains(2));
        Assert.assertFalse(queue.contains(1));
        Assert.assertTrue(queue.contains(3));


        // Remove value 3 (last element)
        try {
            assertEquals(3,queue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(0, queue.size());
        Assert.assertFalse(queue.contains(2));
        Assert.assertFalse(queue.contains(3));
        Assert.assertFalse(queue.contains(1));


    }

    @Test
    void contains() {
        queue.enqueue("hola");
        assertTrue(queue.contains("hola"));
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.enqueue("hola");
        assertEquals(1, queue.size());
    }

    @Test
    void get() {
        queue.enqueue("hola");
        queue.enqueue("mundo");
        try {
            assertEquals("mundo", queue.get(0));
        } catch (DatosIncorrectos e) {
            throw new RuntimeException(e);
        }
    }
}