package uy.edu.um.prog2.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeImplTest {

    @Test
    void testInsertAndFind() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTreeImpl<>();

        tree.insert(4, "Papas");
        tree.insert(35, "Boniatos");
        tree.insert(23, "Zanahorias");
        tree.insert(45, "Perejil");

        assertTrue(tree.find(4));
        assertTrue(tree.find(35));
        assertTrue(tree.find(23));
        assertTrue(tree.find(45));
        assertFalse(tree.find(1000));
    }

    @Test
    void testDelete() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTreeImpl<>();

        tree.insert(4, "Papas");
        tree.insert(35, "Boniatos");
        tree.insert(23, "Zanahorias");
        tree.insert(45, "Perejil");

        assertTrue(tree.find(4));
        assertTrue(tree.find(35));
        assertTrue(tree.find(23));
        assertTrue(tree.find(45));

        tree.delete(4);
        assertFalse(tree.find(4));

        tree.delete(35);
        assertFalse(tree.find(35));

        tree.delete(23);
        assertFalse(tree.find(23));

        tree.delete(45);
        assertFalse(tree.find(45));
    }

    @Test
    void testFindMin() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTreeImpl<>();

        tree.insert(4, "Papas");
        tree.insert(35, "Boniatos");
        tree.insert(23, "Zanahorias");
        tree.insert(45, "Perejil");

        assertEquals("Papas", tree.findMin());
    }

    @Test
    void testFindMax() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTreeImpl<>();

        tree.insert(4, "Papas");
        tree.insert(35, "Boniatos");
        tree.insert(23, "Zanahorias");
        tree.insert(45, "Perejil");

        assertEquals("Perejil", tree.findMax());
    }
}
