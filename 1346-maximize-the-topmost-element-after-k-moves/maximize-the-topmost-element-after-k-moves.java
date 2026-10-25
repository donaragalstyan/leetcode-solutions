class Solution {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1) {
            if (k % 2 == 1) {
                return -1;
            }
            return nums[0];
        }

        if (k == 0) {
            return nums[0];
        }

        if (k == 1) {
            return nums[1];
        }

        int max = -1;

        for (int i = 0; i <= k - 2 && i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        if (k < nums.length) {
            max = Math.max(max, nums[k]);
        }

        return max;
    }
}