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
    HashMap<Integer, Integer> sumToCount = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        int max = 0;

        for (int value : sumToCount.values()) {
            max = Math.max(max, value);
        }

        List<Integer> result = new ArrayList<>();

        for (int n : sumToCount.keySet()) {
            if (sumToCount.get(n) == max) {
                result.add(n);
            }
        }

        int[] arr = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;

    }

    private int dfs(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int leftSum = dfs(root.left);
    int rightSum = dfs(root.right);

    int sum = root.val + leftSum + rightSum;

    sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);

    return sum;
}
}