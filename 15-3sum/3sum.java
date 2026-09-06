class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        int p1 = 0;

        while (p1 < nums.length - 2) {
            int p2 = p1 + 1;
            int p3 = nums.length - 1;

            while (p2 < p3) {
                int sum = nums[p1] + nums[p2] + nums[p3];

                if (sum < 0) {
                    p2++;
                } else if (sum > 0) {
                    p3--;
                } else {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[p1]);
                    ans.add(nums[p2]);
                    ans.add(nums[p3]);
                    res.add(ans);

                    p2++;
                    p3--;

                    while (p2 < p3 && nums[p2] == nums[p2 - 1]) {
                        p2++;
                    }

                    while (p2 < p3 && nums[p3] == nums[p3 + 1]) {
                        p3--;
                    }
                }
            }

            p1++;

            while (p1 < nums.length - 2 && nums[p1] == nums[p1 - 1]) {
                p1++;
            }
        }

        return res;
    }
}