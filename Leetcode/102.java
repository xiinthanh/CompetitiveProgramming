package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    static class TreeNodeWithDepth {
        TreeNode node;
        int depth;

        TreeNodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        // for level i: [level i], [level i + 1], ...
        // BFS
        Deque<TreeNodeWithDepth> queue = new ArrayDeque<>();
        queue.add(new TreeNodeWithDepth(root, 0));

        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        int currentLevel = -1;
        List<Integer> currentLevelNodesValues = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.peekFirst().node;
            int depth = queue.peekFirst().depth;
            queue.pollFirst();

            if (depth > currentLevel) {
                if (currentLevel != -1) {
                    levelOrderTraversal.add(currentLevelNodesValues);
                }
                currentLevel = depth;
                currentLevelNodesValues = new ArrayList<>();
                currentLevelNodesValues.add(node.val);
            } else {
                currentLevelNodesValues.add(node.val);
            }

            if (node.left != null) {
                queue.addLast(new TreeNodeWithDepth(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.addLast(new TreeNodeWithDepth(node.right, depth + 1));
            }
        }

        if (!currentLevelNodesValues.isEmpty()) {
            levelOrderTraversal.add(currentLevelNodesValues);
        }

        return levelOrderTraversal;
    }
}