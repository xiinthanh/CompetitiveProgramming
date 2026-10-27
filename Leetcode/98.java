package Leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public boolean isValidBST(TreeNode root) {
        return (checkValidBST(root)[0] == 1 ? true : false);
    }

    // [isValid, minValue, maxValue]
    private int[] checkValidBST(TreeNode node) {
        if (node == null) {
            return new int[] { 1 };
        }

        int[] leftNode = checkValidBST(node.left);
        int[] rightNode = checkValidBST(node.right);

        int isBST = ((leftNode[0] & rightNode[0]) == 1) ? 1 : 0;
        int maxValue = node.val;
        int minValue = node.val;

        if (leftNode.length > 1) { // is not null
            // the left subtree contains only nodes with keys less than
            // the node's key
            if (leftNode[2] >= node.val) {
                isBST = 0;
            }
            maxValue = Math.max(maxValue, leftNode[2]);
            minValue = Math.min(minValue, leftNode[1]);
        }

        if (rightNode.length > 1) {
            // the right subtree contains only nodes with keys
            // greater than the node's key
            if (node.val >= rightNode[1]) {
                isBST = 0;
            }
            maxValue = Math.max(maxValue, rightNode[2]);
            minValue = Math.min(minValue, rightNode[1]);
        }

        return new int[] { isBST, minValue, maxValue };
    }
}