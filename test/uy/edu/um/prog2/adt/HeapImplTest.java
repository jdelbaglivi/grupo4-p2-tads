package uy.edu.um.prog2.adt;

import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.exceptions.EmptyHeapException;

import static org.junit.Assert.*;

public class HeapImplTest {
    private Heap<Integer, String> heap;

    @Before
    public void setUp() {
        heap = new HeapImpl<>();
    }

    @Test
    public void testInsertAndSize() {
        assertEquals(0, heap.size());

        heap.insert(5, "Value 5");
        heap.insert(3, "Value 3");
        heap.insert(7, "Value 7");

        assertEquals(3, heap.size());
    }

    @Test
    public void testDelete() {
        heap.insert(5, "Value 5");
        heap.insert(3, "Value 3");
        heap.insert(7, "Value 7");

        try{
            heap.delete();
        }catch (EmptyHeapException e){
            fail();
        }

        assertEquals(2, heap.size());
    }

    @Test()
    public void testDeleteEmptyHeap() {
        try{
            heap.delete();
            fail();
        }catch (EmptyHeapException e){
            assertTrue(true);
        }
    }

    @Test
    public void testGetMaxValue() {
        heap.insert(5, "Value 5");
        heap.insert(3, "Value 3");
        heap.insert(7, "Value 7");

        assertEquals("Value 7", heap.getMaxValue());
    }
}
