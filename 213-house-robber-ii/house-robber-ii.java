class Solution {
    int[] memo;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        memo = new int[n];
        Arrays.fill(memo, -1);
        int skipLast = Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 2));

        memo = new int[n];
        Arrays.fill(memo, -1);
        int skipFirst = Math.max(dp(nums, 1, n - 1), dp(nums, 2, n - 1));

        return Math.max(skipLast, skipFirst);
    }

    private int dp(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }

        int nextHouse = dp(nums, start + 2, end);
        int nextNextHouse = dp(nums, start + 3, end);
        memo[start] = nums[start] + Math.max(nextHouse, nextNextHouse);

        return memo[start];
    }
}