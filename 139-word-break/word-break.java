class Solution {
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        Set<String> words = new HashSet<>(wordDict);

        return dfs(s, 0, words);
    }

    private boolean dfs(String s, int start, Set<String> words) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (words.contains(word)) {
                if (dfs(s, end, words)) {
                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false;
        return false;
    }
}
