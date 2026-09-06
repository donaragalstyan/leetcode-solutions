class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortedToReal = new HashMap<>();

        for (int i = 0; i < strs.length; ++i) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String newSorted = new String(c);

            if (sortedToReal.containsKey(newSorted)) {
                sortedToReal.get(newSorted).add(strs[i]);
            } else {
                List<String> newWord = new ArrayList<>();
                newWord.add(strs[i]);
                sortedToReal.put(newSorted, newWord);
            }
        }

        return new ArrayList<>(sortedToReal.values());
    }
}