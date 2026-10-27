package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // check left node, check right node, -> root.
        List<TreeNode> iTraversal = new ArrayList<>();
        List<Integer> nodeDepths = new ArrayList<>();
        inorderTraversal(root, iTraversal, nodeDepths, 0);

        int idQ = 0, idP = iTraversal.size() - 1;
        for (int i = 0; i < iTraversal.size(); i++) {
            if (iTraversal.get(i) == p) {
                idP = i;
            }
            if (iTraversal.get(i) == q) {
                idQ = i;
            }
        }

        TreeNode lca = (nodeDepths.get(idQ) < nodeDepths.get(idP)) ? q : p;
        int lcaDepth = Math.min(nodeDepths.get(idQ), nodeDepths.get(idP));
        for (int i = Math.min(idQ, idP); i <= Math.max(idQ, idP); i++) {
            if (nodeDepths.get(i) < lcaDepth) {
                lca = iTraversal.get(i);
                lcaDepth = nodeDepths.get(i);
            }
        }

        return lca;
    }

    private void inorderTraversal(TreeNode node, List<TreeNode> traversal, List<Integer> nodeDepths, int depth) {
        if (node == null)
            return;
        inorderTraversal(node.left, traversal, nodeDepths, depth + 1);
        traversal.add(node);
        nodeDepths.add(depth);
        inorderTraversal(node.right, traversal, nodeDepths, depth + 1);
    }
}