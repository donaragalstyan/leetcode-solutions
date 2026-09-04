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
    public List<List<Integer>> findLeaves(TreeNode root) {

        
        while (root.left != null || root.right != null) {
            List<Integer> curr = new ArrayList<>();
            dfs(root, curr);

            result.add(curr);
        }

        // result.add(new ArrayList<>{root.value});
        List<Integer> r = new ArrayList<>();
        r.add(root.val);
        result.add(r);


        return result;
    }


    private boolean dfs(TreeNode root, List<Integer> curr) {
        if ((root.left == null && root.right == null)) {
            curr.add(root.val);
            return true;
        }

        if (root.left != null && dfs(root.left, curr)) {
            root.left = null;
        }

        if (root.right != null && dfs(root.right, curr)) {
            root.right = null;
        }

        return false;
    }
}