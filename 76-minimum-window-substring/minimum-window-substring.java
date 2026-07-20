import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> table = new HashMap<>();

        for (char c : t.toCharArray()) {
            table.put(c, table.getOrDefault(c, 0) + 1);
        }

        int begin = 0;
        int end = 0;
        int counter = table.size();
        int len = Integer.MAX_VALUE;

        String ans = "";

        while (end < s.length()) {
            char endChar = s.charAt(end);

            if (table.containsKey(endChar)) {
                table.put(endChar, table.get(endChar) - 1);
                if (table.get(endChar) == 0) {
                    counter--;
                }
            }

            end++;

            while (counter == 0) {
                if (end - begin < len) {
                    len = end - begin;
                    ans = s.substring(begin, end);
                }

                char startChar = s.charAt(begin);

                if (table.containsKey(startChar)) {
                    table.put(startChar, table.get(startChar) + 1);
                    if (table.get(startChar) > 0) {
                        counter++;
                    }
                }

                begin++;
            }
        }

        return ans;
    }
}