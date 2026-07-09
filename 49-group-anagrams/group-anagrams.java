class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        // List<List<String>> ret = new ArrayList<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String newS = new String(ch);


            res.putIfAbsent(newS, new ArrayList<String>());
            res.get(newS).add(s);
        }

        
        return new ArrayList<>(res.values());
    }
}