class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) {
            return -1;
        }

        int sum1 = 0;
        for (int x : nums1) {
            sum1 += x;
        }
        int sum2 = 0;
        for (int x : nums2) {
            sum2 += x;
        }

        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int diff = sum2 - sum1;

        int i = 0;
        int j = nums2.length - 1;
        int ops = 0;

        while (diff > 0) {
            int gap1 = 0;
            if (i < nums1.length) {
                gap1 = 6 - nums1[i];
            }

            int gap2 = 0;
            if (j >= 0) {
                gap2 = nums2[j] - 1;
            }

            if (gap1 >= gap2) {
                diff -= gap1;
                i++;
            } else {
                diff -= gap2;
                j--;
            }
            ops++;
        }

        return ops;
    }
}