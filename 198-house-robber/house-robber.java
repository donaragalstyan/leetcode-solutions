class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return Math.max(dp(nums, 0), dp(nums, 1));
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        int nextHouse = dp(nums, start + 2);
        int nextNextHouse = dp(nums, start + 3);
        memo[start] = nums[start] + Math.max(nextHouse, nextNextHouse);

        return memo[start];
    }
}