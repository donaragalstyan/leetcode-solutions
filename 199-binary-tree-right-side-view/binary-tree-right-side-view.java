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
    List<Integer> rightSide = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return rightSide;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (rightSide.size() == depth) {
            rightSide.add(root.val);
        }
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);
    }

}