class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] combined = new int[intervals.length + 1][];

        for (int i = 0; i < intervals.length; ++i) {
            combined[i] = intervals[i];
        }

        combined[intervals.length] = newInterval;

        return merge(combined);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                res.add(current);
                current = intervals[i];
            }
        }

        res.add(current);

        return res.toArray(new int[0][]);
    }
}