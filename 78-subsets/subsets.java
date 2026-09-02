class Solution {
    private List<List<Integer>> allPossible;
    private List<Integer> curr;
    public List<List<Integer>> subsets(int[] nums) {
        this.allPossible = new ArrayList<>();
        this.curr = new ArrayList<>();
        backtracking(this.allPossible, this.curr, 0, nums);
        return this.allPossible;
    }

    private void backtracking(List<List<Integer>> allPossible, List<Integer> curr, int currLevel, int[] nums) {
         allPossible.add(new ArrayList<>(curr));



        for (int i = currLevel; i < nums.length; ++i) {
            curr.add(nums[i]);
            backtracking(allPossible, curr, i+1, nums);
            curr.remove(curr.size() - 1);
        }
    }
}