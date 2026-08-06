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
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        if (root.left == null && root.right == null) {
            return depth + 1;
        }

        int dLeft = depth(root.left);
        int dRight = depth(root.right);
        return Math.max(dLeft, dRight) + 1;
    }


}