class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        HashMap<Character, Integer> anagram = new HashMap<>();
        for (Character ch : p.toCharArray()) {
            anagram.put(ch, anagram.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> current = new HashMap<>();

        int lengthOfP = p.length();
        char[] sToArray = s.toCharArray();

        int p1 = 0;
        int p2 = 0;

        while (p2 < sToArray.length) {

            current.put(sToArray[p2], current.getOrDefault(sToArray[p2], 0) + 1);

            if (p2 - p1 + 1 > lengthOfP) {
                if (current.get(sToArray[p1]) == 1) {
                    current.remove(sToArray[p1]);
                } else {
                    current.put(
                        sToArray[p1],
                        current.get(sToArray[p1]) - 1
                    );
                }

                p1++;
            }

            if (p2 - p1 + 1 == lengthOfP && current.equals(anagram)) {
                result.add(p1);
            }

            p2++;
        }

        return result;
    }
}