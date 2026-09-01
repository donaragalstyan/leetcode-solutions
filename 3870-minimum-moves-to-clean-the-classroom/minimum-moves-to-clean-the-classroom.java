import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();

        int startRow = 0;
        int startCol = 0;

        int[][] litterIndex = new int[rows][cols];

        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char cell = classroom[r].charAt(c);

                if (cell == 'S') {
                    startRow = r;
                    startCol = c;
                }

                if (cell == 'L') {
                    litterIndex[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int allCollected = (1 << litterCount) - 1;

        boolean[][][][] visited =
            new boolean[rows][cols][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
            startRow,
            startCol,
            energy,
            0
        });

        visited[startRow][startCol][energy][0] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] state = queue.poll();

                int row = state[0];
                int col = state[1];
                int currentEnergy = state[2];
                int mask = state[3];

                if (mask == allCollected) {
                    return moves;
                }

                if (currentEnergy == 0) {
                    continue;
                }

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow < 0 ||
                        newRow >= rows ||
                        newCol < 0 ||
                        newCol >= cols) {
                        continue;
                    }

                    if (classroom[newRow].charAt(newCol) == 'X') {
                        continue;
                    }

                    int newEnergy = currentEnergy - 1;
                    int newMask = mask;

                    char nextCell = classroom[newRow].charAt(newCol);

                    if (nextCell == 'R') {
                        newEnergy = energy;
                    }

                    if (nextCell == 'L') {
                        int index = litterIndex[newRow][newCol];

                        newMask = newMask | (1 << index);
                    }

                    if (!visited[newRow][newCol][newEnergy][newMask]) {
                        visited[newRow][newCol][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            newRow,
                            newCol,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}