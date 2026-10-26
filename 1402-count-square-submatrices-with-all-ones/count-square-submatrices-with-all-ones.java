class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int total = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i > 0 && j > 0 && matrix[i][j] == 1) {
                    int up = matrix[i - 1][j];
                    int left = matrix[i][j - 1];
                    int diag = matrix[i - 1][j - 1];
                    matrix[i][j] += Math.min(up, Math.min(left, diag));
                }
                total += matrix[i][j];
            }
        }
        return total;
    }
}