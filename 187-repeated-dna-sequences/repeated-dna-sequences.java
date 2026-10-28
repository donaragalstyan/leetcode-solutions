class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> count = new HashMap<>();
        List<String> repeated = new ArrayList<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            int c = count.getOrDefault(sub, 0) + 1;
            count.put(sub, c);

            if (c == 2) {
                repeated.add(sub);
            }
        }

        return repeated;
    }
}