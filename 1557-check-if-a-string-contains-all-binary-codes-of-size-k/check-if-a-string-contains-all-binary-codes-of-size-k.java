class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int total = 1 << k;

        if (n - k + 1 < total) {
            return false;
        }

        boolean[] seen = new boolean[total];
        int mask = total - 1;
        int window = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            window = ((window << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1 && !seen[window]) {
                seen[window] = true;
                count++;

                if (count == total) {
                    return true;
                }
            }
        }

        return false;
    }
}