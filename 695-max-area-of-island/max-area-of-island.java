class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid, visited, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int count = 1;

        int[] dir = new int[] {0, 1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            count += dfs(grid, visited, r + dir[i], c + dir[i + 1]);
        }

        return count;
    }
}
