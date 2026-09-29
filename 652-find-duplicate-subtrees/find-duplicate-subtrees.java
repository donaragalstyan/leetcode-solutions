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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        dfs(root, count, result);

        return result;
    }

    private String dfs(TreeNode node, Map<String, Integer> count, List<TreeNode> result) {
        if (node == null) {
            return "";
        }

        String left = dfs(node.left, count, result);
        String right = dfs(node.right, count, result);

        String subtree = node.val + "," + left + "," + right;

        int seen = count.getOrDefault(subtree, 0);

        if (seen == 1) {
            result.add(node);
        }

        count.put(subtree, seen + 1);

        return subtree;
    }
}