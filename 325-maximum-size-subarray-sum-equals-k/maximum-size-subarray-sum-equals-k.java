class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixToIndex = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        // prefix sum 0 exists before the array starts
        prefixToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int needed = prefixSum - k;

            if (prefixToIndex.containsKey(needed)) {
                int startIndex = prefixToIndex.get(needed);
                maxLen = Math.max(maxLen, i - startIndex);
            }

            // only store the first occurrence to maximize length
            if (!prefixToIndex.containsKey(prefixSum)) {
                prefixToIndex.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}