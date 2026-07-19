class Solution {
    public int maxVowels(String s, int k) {
        int vowels = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowels++;
            }
        }

        int maxVowels = vowels;

        for (int right = k; right < s.length(); right++) {
            if (isVowel(s.charAt(right))) {
                vowels++;
            }

            if (isVowel(s.charAt(right - k))) {
                vowels--;
            }

            maxVowels = Math.max(maxVowels, vowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u';
    }
}