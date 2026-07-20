class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) {
            return false;
        }

        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }

        char[] curr = new char[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            curr[i] = s2.charAt(i);
        }

        int start = 0;

        for (int right = s1.length(); right <= s2.length(); right++) {

            HashMap<Character, Integer> windowCount = new HashMap<>();
            for (char ch : curr) {
                windowCount.put(ch, windowCount.getOrDefault(ch, 0) + 1);
            }
            if (windowCount.equals(charToCount)) {
                return true;
            }

            if (right == s2.length()) {
                break;
            }

            for (int i = 1; i < curr.length; i++) {
                curr[i - 1] = curr[i];
            }
            curr[curr.length - 1] = s2.charAt(right);
        }

        return false;
    }
}