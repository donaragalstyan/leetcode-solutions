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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int pathsFromHere = dfs(root, (long) targetSum);

        int pathsFromLeft = pathSum(root.left, targetSum);
        int pathsFromRight = pathSum(root.right, targetSum);

        return pathsFromHere + pathsFromLeft + pathsFromRight;
    }

    private int dfs(TreeNode root, long remaining) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.val == remaining) {
            count++;
        }

        count += dfs(root.left, remaining - root.val);
        count += dfs(root.right, remaining - root.val);

        return count;
    }
}