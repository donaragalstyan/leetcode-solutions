class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) {
            return -1;
        }

        int[][] dp = new int[d + 1][n + 1];

        for (int day = 0; day <= d; day++) {
            for (int jobs = 0; jobs <= n; jobs++) {
                dp[day][jobs] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        for (int day = 1; day <= d; day++) {

            for (int jobs = day; jobs <= n; jobs++) {

                int hardestJobToday = 0;

                for (int split = jobs - 1; split >= day - 1; split--) {

                    hardestJobToday = Math.max(
                        hardestJobToday,
                        jobDifficulty[split]
                    );

                    if (dp[day - 1][split] != Integer.MAX_VALUE) {
                        int difficulty =
                            dp[day - 1][split] + hardestJobToday;

                        dp[day][jobs] = Math.min(
                            dp[day][jobs],
                            difficulty
                        );
                    }
                }
            }
        }

        return dp[d][n];
    }
}