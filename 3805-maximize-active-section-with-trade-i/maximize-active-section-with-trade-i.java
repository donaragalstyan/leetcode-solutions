class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int activeCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                activeCount++;
            }
        }

        String t = "1" + s + "1";

        int previousZeroBlock = 0;
        int maxGain = 0;
        int i = 0;

        while (i < t.length()) {
            if (t.charAt(i) == '1') {
                i++;
                continue;
            }

            int currentZeroBlock = 0;

            while (i < t.length() && t.charAt(i) == '0') {
                currentZeroBlock++;
                i++;
            }

            if (previousZeroBlock > 0) {
                maxGain = Math.max(
                    maxGain,
                    previousZeroBlock + currentZeroBlock
                );
            }

            previousZeroBlock = currentZeroBlock;
        }

        return activeCount + maxGain;
    }
}