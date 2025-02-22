package ru.job4j.taskleetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void testBothTreesEmpty() {
        TreeNode p = null;
        TreeNode q = null;
        assertTrue(solution.isSameTree(p, q), "Оба дерева пустые, должны быть одинаковыми");
    }

    @Test
    void testOneTreeEmpty() {
        TreeNode p = new TreeNode(1);
        TreeNode q = null;
        assertFalse(solution.isSameTree(p, q), "Одно дерево пустое, другое нет – должны быть разными");

        TreeNode p2 = null;
        TreeNode q2 = new TreeNode(1);
        assertFalse(solution.isSameTree(p2, q2), "Одно дерево пустое, другое нет – должны быть разными");
    }

    @Test
    void testDifferentValues() {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        assertFalse(solution.isSameTree(p, q), "Разные значения узлов – деревья разные");
    }

    @Test
    void testSameStructureAndValues() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertTrue(solution.isSameTree(p, q), "Одинаковые структуры и значения – деревья одинаковые");
    }

    @Test
    void testDifferentStructures() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        assertFalse(solution.isSameTree(p, q), "Разные структуры деревьев – деревья разные");
    }

    @Test
    void testComplexDifferentTrees() {
        TreeNode p = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        assertFalse(solution.isSameTree(p, q), "Деревья имеют одинаковые значения, но разную структуру – должны быть разными");
    }
}
    
