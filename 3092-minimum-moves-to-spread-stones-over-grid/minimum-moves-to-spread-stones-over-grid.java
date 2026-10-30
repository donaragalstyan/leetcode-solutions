class Solution {
    List<int[]> empty = new ArrayList<>();
    List<int[]> extra = new ArrayList<>();

    public int minimumMoves(int[][] grid) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[r][c] == 0) {
                    empty.add(new int[]{r, c});
                }

                for (int k = 1; k < grid[r][c]; k++) {
                    extra.add(new int[]{r, c});
                }
            }
        }

        boolean[] used = new boolean[extra.size()];
        return dfs(0, used);
    }

    private int dfs(int index, boolean[] used) {
        if (index == empty.size()) {
            return 0;
        }

        int best = Integer.MAX_VALUE;

        for (int i = 0; i < extra.size(); i++) {
            if (used[i]) continue;

            int[] stone = extra.get(i);
            int[] target = empty.get(index);

            int distance =
                Math.abs(stone[0] - target[0]) +
                Math.abs(stone[1] - target[1]);

            used[i] = true;

            int remaining = dfs(index + 1, used);

            best = Math.min(best, distance + remaining);

            used[i] = false;
        }

        return best;
    }
}
