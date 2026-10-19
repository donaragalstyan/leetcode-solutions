class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int shift = (findMaxIndex(nums) + 1) % n;

        int[] sorted = buildSorted(nums, shift);
        int idx = binarySearch(sorted, target);

        if (idx == -1) {
            return -1;
        }
        return (idx + shift) % n;
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

    private int[] buildSorted(int[] nums, int shift) {
        int n = nums.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[(i + shift) % n];
        }
        return sorted;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}