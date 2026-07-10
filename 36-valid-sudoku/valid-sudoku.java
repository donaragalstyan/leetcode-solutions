class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];

                if (num == '.') {
                    continue;
                }

                String rowKey = num + " in row " + r;
                String colKey = num + " in col " + c;
                String boxKey = num + " in box " + (r / 3) + "," + (c / 3);

                if (seen.contains(rowKey) || 
                    seen.contains(colKey) || 
                    seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }

        return true;
    }
}