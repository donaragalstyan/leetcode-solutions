class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; ++r) {
            for(int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }


    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        int[] neigs = new int[] {-1, 0, 1, 0, -1};
        grid[r][c] = 0;
        int area = 1;
        for (int i = 0; i < 4; ++i) {
            area += dfs(grid, r + neigs[i], c + neigs[i + 1]);
        }
        return area;
    }
}