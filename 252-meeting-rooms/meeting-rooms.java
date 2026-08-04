class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            int previousEnd = intervals[i - 1][1];
            int currentStart = intervals[i][0];

            if (currentStart < previousEnd) {
                return false;
            }
        }

        return true;
    }
}