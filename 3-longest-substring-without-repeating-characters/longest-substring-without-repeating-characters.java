
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Set<Character> set = new HashSet<>();
        int p1 = 0;
        int p2 = 0;

        while (p2 < s.length()) {
            if (set.contains(s.charAt(p2))) {
                set.remove(s.charAt(p1));
                p1++;
            } else {
                set.add(s.charAt(p2));
                p2++;
                max = Math.max(max, p2 - p1);
            }
        }

        return max;
    }
}
