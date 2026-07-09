class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < nums.length) {
            if (nums[j] > nums[i]) {
                ans++;
                i++;
            }

            j++;
        }

        return ans;
    }
}