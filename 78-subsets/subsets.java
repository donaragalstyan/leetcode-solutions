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

        this.res.add(new ArrayList<>(curr));

        for (int i = currLevel; i < this.nums.length; ++i) {
            curr.add(nums[i]);
            backtracking(i+1, curr);
            curr.remove(curr.size() - 1);
        }

        
    }
}