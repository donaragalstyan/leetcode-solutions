class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) {
            return false;
        }

        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }

        int start = 0;

        for (int right = 0; right < s2.length(); right++) {
            char ch = s2.charAt(right);

            if (charToCount.containsKey(ch)) {
                charToCount.put(ch, charToCount.get(ch) - 1);
            }

            if (right - start + 1 > s1.length()) {
                char leftChar = s2.charAt(start);
                if (charToCount.containsKey(leftChar)) {
                    charToCount.put(leftChar, charToCount.get(leftChar) + 1);
                }
                start++;
            }

            if (right - start + 1 == s1.length() && allZero(charToCount)) {
                return true;
            }
        }

        return false;
    }

    private boolean allZero(HashMap<Character, Integer> map) {
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}