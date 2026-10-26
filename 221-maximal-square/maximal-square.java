class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i > 0 && j > 0 && matrix[i][j] == '1') {
                    int up = matrix[i - 1][j] - '0';
                    int left = matrix[i][j - 1] - '0';
                    int diag = matrix[i - 1][j - 1] - '0';
                    matrix[i][j] = (char) ('0' + 1 + Math.min(up, Math.min(left, diag)));
                }
                max = Math.max(max, matrix[i][j] - '0');
            }
        }
        return max * max;
    }
}