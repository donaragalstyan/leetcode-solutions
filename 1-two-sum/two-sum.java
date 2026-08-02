class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            int rem = target - nums[i];
            if (numToIndex.containsKey(rem)) {
                ret[0] = i;
                ret[1] = numToIndex.get(rem);
            }

            numToIndex.put(nums[i], i);
        }

        return ret;
    }
}