class Solution {
    public boolean exist(char[][] board, String word) {
        // search through board. If we get to the first letter needed, then we call helper
        boolean visited[][] = new boolean[board.length][board[0].length];
        boolean found = false;
        for (int i = 0; i < board.length; ++i) {
        for (int j = 0; j < board[0].length; ++j) {
            if (board[i][j] == word.charAt(0)) {
                found = helper(board, word, 0, visited, i, j);
                if (found) {
                    return true;
                }
            }
        }
    }

        return found;
    }

    private boolean helper(char[][] board, String word, int idx, boolean[][] visited, int r, int c) {

        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length ||
            visited[r][c] ||
            board[r][c] != word.charAt(idx)) {
            return false;
        }


        visited[r][c] = true;
        int[] dir = {-1, 0, 1, 0, -1};
        boolean found = false;
        for (int i = 0; i < 4; ++i) {
            found = helper(board, word, idx + 1, visited, r + dir[i], c + dir[i + 1]);
            if (found == true) {
                break;
            }
        }
        visited[r][c] = false;
        return found;
    }
}