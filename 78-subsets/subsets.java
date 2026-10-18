class Solution {
    private List<List<Integer>> allPossible = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(new ArrayList<>(), 0, nums);
        return allPossible;
    }

    private void backtracking(List<Integer> curr, int start, int[] nums) {
        allPossible.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; ++i) {
            curr.add(nums[i]);
            backtracking(curr, i + 1, nums);
            curr.remove(curr.size() - 1);
        }
    }
}