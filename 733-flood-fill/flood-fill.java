class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        fill(image, color, start, visited, sr, sc);
        return image;
    }

    private void fill(int[][] image, int color, int start, boolean[][] visited, int r, int c) {
        if (r < 0 || r > image.length - 1 || c < 0 || c > image[0].length - 1 || visited[r][c] == true || image[r][c] != start) {
            return;
        }

        image[r][c] = color;
        visited[r][c] = true;
        int[] dir = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; ++i) {
            fill(image, color, start, visited, r + dir[i], c + dir[i + 1]);
        }
    }
}