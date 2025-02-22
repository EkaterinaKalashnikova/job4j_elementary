package ru.job4j.taskleetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResolveTest {

    Resolve resolve = new Resolve();

    @Test
    void testEmptyTree() {
        TreeNode root = null;
        assertTrue(resolve.isSymmetric(root), "Пустое дерево должно быть симметричным");
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertTrue(resolve.isSymmetric(root), "Дерево с одним узлом должно быть симметричным");
    }

    @Test
    void testPerfectSymmetricTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        assertTrue(resolve.isSymmetric(root), "Идеально симметричное дерево должно быть симметричным");
    }

    /** @Test
    void testAsymmetricTreeDifferentValues() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                new TreeNode(2, null, new TreeNode(3))
        );
        assertFalse(resolve.isSymmetric(root), "Дерево с разными значениями в зеркальных узлах не должно быть симметричным");
    }
*/
    @Test
    void testAsymmetricTreeDifferentStructure() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(3), null)
        );
        assertFalse(resolve.isSymmetric(root), "Дерево с разной структурой не должно быть симметричным");
    }

    @Test
    void testOnlyLeftSubtree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                null
        );
        assertFalse(resolve.isSymmetric(root), "Дерево с одним поддеревом не должно быть симметричным");
    }
}
    
