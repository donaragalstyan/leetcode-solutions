class Solution {
    int[] memo;

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        memo = new int[points.length];
        Arrays.fill(memo, -1);

        return Math.max(dp(points, 0), dp(points, 1));
    }

    private int dp(int[] points, int start) {
        if (start >= points.length) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        int nextOne = dp(points, start + 2);
        int nextNextOne = dp(points, start + 3);

        memo[start] = points[start] + Math.max(nextOne, nextNextOne);

        return memo[start];
    }
}
