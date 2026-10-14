class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; ++i) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                res.add(current);
                current = intervals[i];
            }
        }

        res.add(current);

        return res.toArray(new int[res.size()][]);
    }
}