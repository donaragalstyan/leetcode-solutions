class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> charToChar = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (charToChar.containsKey(s.charAt(i))) {
                if (charToChar.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                } else {
                    continue;
                }
            } else {
                if (charToChar.containsValue(t.charAt(i))) {
                    return false;
                }
                charToChar.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}