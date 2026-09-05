class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;
        int p1 = 0;
        int p2 = 0;

        HashSet<Character> set = new HashSet<>();
        while (p2 < s.length()) {

            if (set.contains(s.charAt(p2))) {
                set.remove(s.charAt(p1));
                p1++;
            } else {
                set.add(s.charAt(p2));

                currLength = p2 - p1 + 1;
                maxLength = Math.max(maxLength, currLength);

                p2++;
            }
        }

        return maxLength;
    }
}