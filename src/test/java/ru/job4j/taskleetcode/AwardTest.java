package ru.job4j.taskleetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

class AwardTest {
    Award award = new Award();

    @Test
    void testEmptyTree() {
        TreeNode root = null;
        assertTrue(award.pathSum(root, 10).isEmpty(), "Пустое дерево не должно содержать путей");
    }

    @Test
    void testSingleMatchingNode() {
        TreeNode root = new TreeNode(5);
        List<List<Integer>> expected = List.of(List.of(5));
        assertEquals(expected, award.pathSum(root, 5), "Дерево с единственным узлом, равным targetSum, должно содержать один путь");
    }

    @Test
    void testSingleNonMatchingNode() {
        TreeNode root = new TreeNode(5);
        assertTrue(award.pathSum(root, 10).isEmpty(), "Дерево с одним узлом, не равным targetSum, не должно содержать путей");
    }

    @Test
    void testMultiplePaths() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );

        int targetSum = 22;
        List<List<Integer>> expected = List.of(
                List.of(5, 4, 11, 2),
                List.of(5, 8, 4, 5)
        );

        assertEquals(expected, award.pathSum(root, targetSum), "Должны быть найдены все корректные пути");
    }

    @Test
    void testNoValidPaths() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        int targetSum = 5;
        assertTrue(award.pathSum(root, targetSum).isEmpty(), "Не должно быть путей, если сумма не достигается");
    }

    @Test
    void testNegativeNumbers() {
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        int targetSum = -5;
        List<List<Integer>> expected = List.of(List.of(-2, -3));

        assertEquals(expected, award.pathSum(root, targetSum), "Должен быть найден путь с отрицательными числами");
    }
}
    
