
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] time = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    dfs(grid, time, i, j, 0);
                }
            }
        }

        int maxTime = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    maxTime = Math.max(maxTime, time[i][j]);
                }
            }
        }

        return maxTime;
    }

    private void dfs(int[][] grid, int[][] time, int r, int c, int minutes) {
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] == 0 ||
            minutes >= time[r][c]) {
            return;
        }

        time[r][c] = minutes;

        int[] dir = {0, 1, 0, -1, 0};

        for (int i = 0; i < 4; ++i) {
            dfs(grid, time, r + dir[i], c + dir[i + 1], minutes + 1);
        }
    }
}
