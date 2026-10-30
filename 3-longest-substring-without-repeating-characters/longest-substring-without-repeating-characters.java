class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int p1 = 0;
        int p2 = 0;
        int maxLen = 0;

        while (p2 < s.length()) {
            if (set.contains(s.charAt(p2))) {
                set.remove(s.charAt(p1));
                p1++;
            } else {
                set.add(s.charAt(p2));
                maxLen = Math.max(maxLen, p2 - p1 + 1);
                p2++;
            }
        }

        return maxLen;
    }
}