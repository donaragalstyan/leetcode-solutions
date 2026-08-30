class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> positionToIndex = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            positionToIndex.put(stones[i], i);
        }

        Map<String, Boolean> memo = new HashMap<>();

        return dfs(stones, 0, 0, positionToIndex, memo);
    }

    private boolean dfs(
        int[] stones,
        int index,
        int lastJump,
        Map<Integer, Integer> positionToIndex,
        Map<String, Boolean> memo
    ) {
        if (index == stones.length - 1) {
            return true;
        }

        String key = index + "," + lastJump;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {

            if (nextJump <= 0) {
                continue;
            }

            int nextPosition = stones[index] + nextJump;

            if (positionToIndex.containsKey(nextPosition)) {
                int nextIndex = positionToIndex.get(nextPosition);

                if (dfs(stones, nextIndex, nextJump, positionToIndex, memo)) {
                    memo.put(key, true);
                    return true;
                }
            }
        }

        memo.put(key, false);
        return false;
    }
}