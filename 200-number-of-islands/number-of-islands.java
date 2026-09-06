class Solution {
    char[][] mygrid;
    public int numIslands(char[][] grid) {
        int total = 0;
        for(int r = 0; r < grid.length; ++r){
            for(int c = 0; c < grid[0].length; ++c){
                if(grid[r][c] == '1'){
                    total ++;
                    grid = dfs(grid, r, c);
                }
            }
        }
        return total;
    }

    private char[][] dfs( char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return grid;
        }

        int[] neigs = new int[] {-1, 0, 1, 0, -1};
        grid[r][c] = '0';
        for(int i = 0; i < 4; ++i){
            dfs(grid, r + neigs[i], c + neigs[i+1]);
        }

        return grid;
    }
}