class Solution {
    public boolean isAnagram(String s, String t) {
        // HashMap<String, Character[]> wordToSortedLetters = new HashMap<>();
        char[] sSorted = s.toCharArray();
        char[] tSorted = t.toCharArray();

        Arrays.sort(sSorted);
        Arrays.sort(tSorted);
        
        return Arrays.equals(sSorted, tSorted);

    }
}