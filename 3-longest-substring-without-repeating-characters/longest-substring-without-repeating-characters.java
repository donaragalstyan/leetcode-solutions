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
        while (p1 <= p2 && p2 < s.length()) {
            set.clear();
            for(int i = p1; i <= p2; ++i) {
                set.add(s.charAt(i));
            }

            if (set.size() < p2 - p1 + 1) {
                set.clear();
                p1++;
            } else {
                currLength = set.size();
                // set.clear();
                maxLength = Math.max(maxLength, currLength);
                p2++;
            }
        }

        return maxLength;
    }
}