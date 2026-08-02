class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int answer = 0;

        for (int num : nums) {
            prefixSum += num;

            int neededPrefix = prefixSum - goal;

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