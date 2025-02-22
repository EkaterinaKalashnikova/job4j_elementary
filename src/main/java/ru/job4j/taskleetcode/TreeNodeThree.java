package ru.job4j.taskleetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeThree {
    int val;
    TreeNodeThree left;
    TreeNodeThree right;

    TreeNodeThree() {

    }

    TreeNodeThree(int val) {
        this.val = val;
    }

    TreeNodeThree(int val, TreeNodeThree left, TreeNodeThree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution class where we define the method to find all root-to-leaf paths
 * that add up to a given target sum.
 */
class Award {
    /** A list to store all the paths that sum to the target*/
    private List<List<Integer>> paths = new ArrayList<>();
    /** A temporary list to keep track of the current path*/
    private List<Integer> currentPath = new ArrayList<>();

    /**
     * Finds all paths from root to leaves that sum to targetSum.
     * @param root The root of the tree.
     * @param targetSum The sum that each path needs to add up to.
     * @return A list of all paths that sum to targetSum.
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return paths;
    }

    /**
     * Performs a depth-first search to find all paths with the target sum.
     * @param node The current node in the recursion.
     * @param remainingSum The remaining sum after subtracting the node's value.
     */
    private void dfs(TreeNode node, int remainingSum) {
        if (node == null) {
            /** If we've reached a null node, just return.*/
            return;
        }

        /** Subtract the node's value from the remaining sum and add the node's value to the current path*/
        remainingSum -= node.val;
        currentPath.add(node.val);

        /** Check if it's a leaf node and the remaining sum is zero, which means we've found a valid path*/
        if (node.left == null && node.right == null && remainingSum == 0) {
            /** If so, add a copy of the current path to the list of valid paths*/
            paths.add(new ArrayList<>(currentPath));
        }

        /** Recurse deeper into the tree*/
        dfs(node.left, remainingSum);  /** Go left*/
        dfs(node.right, remainingSum); /** Go right*/

        /** After exploring both sides, remove the current node's value before going back up the tree*/
        currentPath.remove(currentPath.size() - 1);
    }
}
