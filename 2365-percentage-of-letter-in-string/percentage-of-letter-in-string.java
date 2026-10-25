class Solution {
    public int percentageLetter(String s, char letter) {
        int total = s.length();
        int numLetter = 0;
        for (int i = 0; i < total; ++i) {
            if (s.charAt(i) == letter) {
                numLetter++;
            }
        }

        return (int) (numLetter * 100) / total;
    }
}