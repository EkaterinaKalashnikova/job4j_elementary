package ru.job4j.collection.binarytree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AvlTreeTest {

    /**
     * @Test void simmetricalOrderIsOk() {
     * AvlTree<Integer> tree = new AvlTree<>();
     * for (int i = 1; i < 8; i++) {
     * tree.insert(i);
     * }
     * List<Integer> list = tree.inSymmetricalOrder();
     * assertThat(list).containsExactly(1, 2, 3, 4, 5, 6, 7);
     * }
     */

    @Test
    void insertAndRemoveWorksCorrectly() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        assertThat(tree.contains(10)).isTrue();
        assertThat(tree.contains(20)).isTrue();
        assertThat(tree.contains(5)).isTrue();
        assertThat(tree.contains(15)).isFalse();
        tree.remove(10);
        assertThat(tree.contains(10)).isFalse();
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(5, 20);
    }

    /**
     * @Test void searchForNonExistingElementReturnsFalse() {
     * AvlTree<Integer> tree = new AvlTree<>();
     * tree.insert(1);
     * tree.insert(2);
     * tree.insert(3);
     * assertThat(tree.contains(10)).isFalse();
     * }
     */

    @Test
    void minimumElementIsCorrect() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(3);
        assertThat(tree.minimum()).isEqualTo(3);
    }

    @Test
    void maximumElementIsCorrect() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(25);
        assertThat(tree.maximum()).isEqualTo(25);
    }

    @Test
    void insertDuplicateDoesNotAddNewElement() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(10);
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(10);
    }

    /** @Test void treeBalancesAfterInsertion() {
    AvlTree<Integer> tree = new AvlTree<>();
    tree.insert(10);
    tree.insert(20);
    tree.insert(5);
    tree.insert(30);
    tree.insert(25);
    List<Integer> list = tree.inSymmetricalOrder();
    assertThat(list).containsExactly(5, 10, 20, 25, 30);
    }*/

    /**  @Test void treeBalancesAfterDeletion() {
    AvlTree<Integer> tree = new AvlTree<>();
    tree.insert(10);
    tree.insert(20);
    tree.insert(5);
    tree.insert(30);
    tree.insert(25);
    tree.remove(20);
    List<Integer> list = tree.inSymmetricalOrder();
    assertThat(list).containsExactly(5, 10, 25, 30);
    }*/
}
    
