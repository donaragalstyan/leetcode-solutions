class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int weight = target; weight >= stone; weight--) {
                if (dp[weight - stone] == true) {
                    dp[weight] = true;
                }
            }
        }

        for (int weight = target; weight >= 0; weight--) {
            if (dp[weight] == true) {
                return sum - (2 * weight);
            }
        }

        return 0;
    }
}