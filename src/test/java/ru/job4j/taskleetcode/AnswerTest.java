package ru.job4j.taskleetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnswerTest {
    Answer answer = new Answer();

    @Test
    void testEmptyTree() {
        TreeNode root = null;
        assertTrue(answer.isBalanced(root), "Пустое дерево должно считаться сбалансированным");
    }

    @Test
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertTrue(answer.isBalanced(root), "Дерево с одним узлом должно быть сбалансированным");
    }

    @Test
    void testPerfectBalancedTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        assertTrue(answer.isBalanced(root), "Идеально сбалансированное дерево должно считаться сбалансированным");
    }

    @Test
    void testLeftHeavyTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
                null
        );
        assertFalse(answer.isBalanced(root), "Левосторонне несбалансированное дерево не должно считаться сбалансированным");
    }

    @Test
    void testRightHeavyTree() {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))
        );
        assertFalse(answer.isBalanced(root), "Правосторонне несбалансированное дерево не должно считаться сбалансированным");
    }

   /** @Test
    void testAlmostBalancedTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
                new TreeNode(5)
        );
        assertTrue(answer.isBalanced(root), "Дерево, в котором разница высот не превышает 1, должно считаться сбалансированным");
    }*/
}
    
