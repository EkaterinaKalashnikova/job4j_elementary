package ru.job4j.taskleetcode;

public class TreeNodeToo {
    int val;        /** Variable for the value of the node.*/
    TreeNodeToo left;  /** Pointer to the left child.*/
    TreeNodeToo right; /** Pointer to the right child.*/

    /** Default constructor.*/
   TreeNodeToo() {

   }

    /**Constructor with the node's value.*/
    TreeNodeToo(int val) {
        this.val = val;
    }

    /** Constructor with the node's value, left, and right children.*/
    TreeNodeToo(int val, TreeNodeToo left, TreeNodeToo right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Answer {
    /**
     * Determines if a binary tree is balanced.
     * In a balanced tree, the height of the two subtrees of any node never differ by more than one.
     *
     * @param root The root of the binary tree.
     * @return true if the tree is balanced, false otherwise.
     */
    public boolean isBalanced(TreeNode root) {
        /** A non-negative height indicates that the tree is balanced,
         while -1 represents an imbalance.*/
        return calculateHeight(root) >= 0;
    }

    /**
     * Recursively calculates the height of a binary tree.
     * Returns -1 if the subtree is unbalanced.
     *
     * @param node The node to calculate height of.
     * @return The height of the tree if balanced, otherwise -1.
     */
    private int calculateHeight(TreeNode node) {
        /** Tree with no nodes has height 0.*/
        if (node == null) {
            return 0;
        }

        /** Recursively find the height of the left and right subtrees.*/
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        /** Check if left or right subtree is unbalanced or if they differ in height by more than 1.*/
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Tree is not balanced.
        }

        /** Current node height is max of left and right subtree heights plus 1 (for the current node).*/
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
