class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] candidates, int remaining,
                           int start, List<Integer> curr) {
        if (remaining == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > remaining) {
                break;
            }

            curr.add(candidates[i]);

            backtrack(candidates, remaining - candidates[i],
                      i + 1, curr);
                      
            curr.remove(curr.size() - 1);
        }
    }
}