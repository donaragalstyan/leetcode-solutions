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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int total, int targetSum) {
        if (root == null) {
            return false;
        }

        total += root.val;

        if (root.left == null && root.right == null) {
            return total == targetSum;
        }

        return dfs(root.left, total, targetSum) || dfs(root.right, total, targetSum);
    }
}