class Solution {
    public int search(int[] nums, int target) {
        int pivot = findMaxIndex(nums);

        int result = binarySearch(nums, target, 0, pivot);

        if (result != -1) {
            return result;
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    private int findMaxIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] <= nums[right]) {
            return right;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums.length - 1;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}