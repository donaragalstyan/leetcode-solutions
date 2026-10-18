class Solution {

    private List<List<Integer>> allPossible = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(new ArrayList<>(), 0, nums);
        return allPossible;
    }

    private void backtracking(List<Integer> curr, int start, int[] nums) {
        allPossible.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtracking(curr, i + 1, nums);
            curr.remove(curr.size() - 1);
        }
    }
}