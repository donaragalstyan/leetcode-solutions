class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longestDuration = releaseTimes[0];
        char longestKey = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed.charAt(i);

            if (duration > longestDuration) {
                longestDuration = duration;
                longestKey = currentKey;
            } 
            else if (duration == longestDuration) {
                if (currentKey > longestKey) {
                    longestKey = currentKey;
                }
            }
        }

        return longestKey;
    }
}