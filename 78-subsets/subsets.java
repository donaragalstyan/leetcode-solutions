class Solution {
    private int[] nums;
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        backtracking(0, new ArrayList<>());
        return this.res;


    }


    private void backtracking(int currLevel, List<Integer> curr) {
        if (currLevel == this.nums.length) {
            this.res.add(new ArrayList<>(curr));
            return;
        }


        curr.add(nums[currLevel]);
        backtracking(currLevel + 1, curr);
        curr.remove((Integer) nums[currLevel]);
        backtracking(currLevel + 1, curr);
    }
}