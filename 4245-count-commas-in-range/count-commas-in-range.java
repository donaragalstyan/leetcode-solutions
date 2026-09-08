class Solution {
    public int countCommas(int n) {
        int res = 0;

        for (int i = 1; i <= n; ++i) {
            res += (String.valueOf(i).length() - 1) / 3;
        }

        return res;
    }
}