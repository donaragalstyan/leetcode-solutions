class Solution {
    public int longestBeautifulSubstring(String word) {
        int max = 0;
        int start = 0;
        int distinct = 1;

        for (int i = 1; i < word.length(); i++) {

            if (word.charAt(i) < word.charAt(i - 1)) {
                start = i;
                distinct = 1;
            } else if (word.charAt(i) > word.charAt(i - 1)) {
                distinct++;
            }

            if (distinct == 5) {
                max = Math.max(max, i - start + 1);
            }
        }

        return max;
    }
}