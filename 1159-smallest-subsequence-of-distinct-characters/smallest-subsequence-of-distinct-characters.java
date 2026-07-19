class Solution {
    public String smallestSubsequence(String s) {
        int[] remaining = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {
            remaining[c - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            remaining[index]--;

            if (used[index]) {
                continue;
            }

            while (stack.length() > 0
                    && stack.charAt(stack.length() - 1) > c
                    && remaining[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                used[removed - 'a'] = false;
            }

            stack.append(c);
            used[index] = true;
        }

        return stack.toString();
    }
}