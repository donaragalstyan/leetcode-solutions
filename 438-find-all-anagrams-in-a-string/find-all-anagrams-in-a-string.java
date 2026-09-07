class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for(Character ch : p.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }

        int p1 = 0;
        int p2 = p.length();

        HashMap<Character, Integer> curr = new HashMap<>();
        for (int i = p1; i < p2; ++i) {
            char ch = s.charAt(i);
            curr.put(ch, curr.getOrDefault(ch, 0) + 1);
        }

        while (true) {
            if (curr.equals(charToCount)) {
                res.add(p1);
            }

            if (p2 == s.length()) {
                break;
            }

            char leaving = s.charAt(p1);

            if (curr.get(leaving) == 1) {
                curr.remove(leaving);
            } else {
                curr.put(leaving, curr.get(leaving) - 1);
            }

            char entering = s.charAt(p2);
            curr.put(entering, curr.getOrDefault(entering, 0) + 1);

            p1++;
            p2++;
        }

        return res;
    }
}