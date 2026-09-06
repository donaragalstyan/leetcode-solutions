class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int currArea = 0;
        int p1 = 0;
        int p2 = height.length - 1;

        while (p1 < p2) {
            currArea = Math.min(height[p1], height[p2]) * (p2 - p1);
            maxArea = Math.max(currArea, maxArea);

            if (height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }

        return maxArea;
    }
}