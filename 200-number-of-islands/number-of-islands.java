class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        for (int i = 0; i < visited.length; ++i) {
            for (int j = 0; j < visited[0].length; ++j) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && visited[i][j] == -1) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }


    private void dfs(char[][] grid, int[][] visited, int row, int col) {
        if (row < 0 || row > grid.length -1 || col < 0 || col > grid[0].length -1 || visited[row][col] != -1 || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = 1;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            dfs(grid, visited, row + dirs[i], col+dirs[i+1]);
        }
    }
}