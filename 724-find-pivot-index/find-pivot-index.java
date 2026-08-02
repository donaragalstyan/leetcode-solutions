class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i];
        }

        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int leftSum;
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum = left[i - 1];
            }

            int rightSum;
            if (i == n - 1) {
                rightSum = 0;
            } else {
                rightSum = right[i + 1];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}