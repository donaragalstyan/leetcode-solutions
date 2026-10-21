class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtracking(new ArrayList<>(), nums);
        return ans;
    }

    private void backtracking(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < nums.length; ++i) {
            if (curr.contains(nums[i])) {
                continue;
            }

            curr.add(nums[i]);
            backtracking(curr, nums);
            curr.remove(curr.size() - 1);
        }

    }
}



