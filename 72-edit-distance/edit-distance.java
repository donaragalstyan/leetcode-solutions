class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return recurse(word1, word2, 0, 0);
    }

    private int recurse(String word1, String word2, int i, int j) {

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = recurse(word1, word2, i + 1, j + 1);
            return memo[i][j];
        }

        int insert = recurse(word1, word2, i, j + 1);
        int delete = recurse(word1, word2, i + 1, j);
        int replace = recurse(word1, word2, i + 1, j + 1);

        memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        return memo[i][j];
    }
}