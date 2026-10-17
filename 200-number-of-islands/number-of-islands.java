class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (boolean[] row : visited) {
            Arrays.fill(row, false); 
        }
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return count;
    }


    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || visited[r][c] == true || grid[r][c] == '0') {
            return;
        }


        visited[r][c] = true;
        int[] dir = new int[] {0, -1, 0, 1, 0};
        for (int i = 0; i < 4; ++i) {
            dfs(grid, r+dir[i], c+dir[i+1], visited);
        }
    }
}