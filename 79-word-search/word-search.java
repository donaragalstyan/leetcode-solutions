class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, new boolean[board.length][board[0].length], i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int r, int c, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if(r < 0 || r > board.length - 1 || c < 0 || c >= board[0].length || visited[r][c]){
            return false;
        }

        visited[r][c] = true;

        if (board[r][c] == word.charAt(idx)) {
            int[] dir = new int[] {-1, 0, 1, 0, -1};
            for (int i = 0; i < 4; ++i) {
                if (dfs(board, visited, r + dir[i], c + dir[i+1], word, idx+1)) {
                    return true;
                }
            }
        }

        visited[r][c] = false;
        return false;
    }
}