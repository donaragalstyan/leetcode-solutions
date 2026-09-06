class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = bfs(grid, queue);

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }

    private int bfs(int[][] grid, Queue<int[]> queue) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] neigs = {-1, 0, 1, 0, -1};
        int minutes = 0;

        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                    for (int d = 0; d < 4; ++d) {
                        if (r + neigs[d] >= 0 && r + neigs[d] < rows && c + neigs[d + 1] >= 0 && c + neigs[d + 1] < cols && grid[r + neigs[d]][c + neigs[d + 1]] == 1) {
                            grid[r + neigs[d]][c + neigs[d + 1]] = 2;
                            queue.add(new int[]{r + neigs[d], c + neigs[d + 1]});
                        }
                    }
                }
            }

            if (minutes <= 0) {
                minutes = 0;
            } else {
                minutes -= 1;
            }
                return minutes;
            }
       
    }