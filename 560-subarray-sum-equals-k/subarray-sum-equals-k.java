class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();

        // A prefix sum of 0 has appeared once before we start.
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int answer = 0;

        for (int num : nums) {
            prefixSum += num;

            int neededPrefix = prefixSum - k;

            if (prefixCount.containsKey(neededPrefix)) {
                answer += prefixCount.get(neededPrefix);
            }

            prefixCount.put(
                prefixSum,
                prefixCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return answer;
    }
}