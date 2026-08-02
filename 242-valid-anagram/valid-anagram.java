class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sToMap = new HashMap<>();
        Map<Character, Integer> tToMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            sToMap.put(ch, sToMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            tToMap.put(ch, tToMap.getOrDefault(ch, 0) + 1);
        }

        return sToMap.equals(tToMap);
    }
}