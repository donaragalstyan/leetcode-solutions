class Solution {
    public String robotWithString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        char minChar = 'a';

        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            stack.push(c);

            while (minChar < 'z' && count[minChar - 'a'] == 0) {
                minChar++;
            }

            while (!stack.isEmpty() && stack.peek() <= minChar) {
                res.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }
}