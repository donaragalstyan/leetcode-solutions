/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return total;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftIsUnival = dfs(root.left);
        boolean rightIsUnival = dfs(root.right);

        if (!leftIsUnival || !rightIsUnival) {
            return false;
        }

        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        total++;
        return true;
    }
}