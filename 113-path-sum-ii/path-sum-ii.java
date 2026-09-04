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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, 0, path);

        return result;
    }

    private void dfs(TreeNode node, int targetSum, int currentSum, List<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        currentSum += node.val;

        if (node.left == null && node.right == null && currentSum == targetSum) {
            result.add(new ArrayList<>(path));
        }

        dfs(node.left, targetSum, currentSum, path);
        dfs(node.right, targetSum, currentSum, path);

        path.remove(path.size() - 1);
    }
}