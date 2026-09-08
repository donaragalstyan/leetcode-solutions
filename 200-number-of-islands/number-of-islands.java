class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[i][col] == '1') {
                    count++;
                    dfs(grid, i, col);
                }
            }
        }

        return count;
    }


    private void dfs(char[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        grid[r][c] = '0';
        for (int i = 0; i < 4; ++i) {
            dfs(grid, r+dirs[i], c+dirs[i+1]);
        }
    }
}