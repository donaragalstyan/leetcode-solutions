class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> charToString = new HashMap<>();
        for (String s : strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            List<String> anagr = charToString.getOrDefault(key, new ArrayList<>());
            anagr.add(s);
            charToString.put(key, anagr);
        }

        List<List<String>> nestedList = new ArrayList<>(charToString.values());
        return nestedList;
    }
}