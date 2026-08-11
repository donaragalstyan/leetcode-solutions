class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        
        List<String> list = new ArrayList<>(freq.keySet());

        
        Collections.sort(list, (a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }

            return a.compareTo(b);
        });

        return list.subList(0, k);

    }
}