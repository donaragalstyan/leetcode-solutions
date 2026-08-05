class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounts = new HashMap<>();

        prefixCounts.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int needed = prefixSum - k;

            if (prefixCounts.containsKey(needed)) {
                count += prefixCounts.get(needed);
            }

            prefixCounts.put(
                prefixSum,
                prefixCounts.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }
}