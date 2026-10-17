class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> starts = new HashSet<>();
        for (String w : startWords) {
            starts.add(sortChars(w));
        }

        int count = 0;
        for (String t : targetWords) {
            String sorted = sortChars(t);
            for (int i = 0; i < sorted.length(); i++) {
                String candidate = sorted.substring(0, i) + sorted.substring(i + 1);
                if (starts.contains(candidate)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private String sortChars(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}