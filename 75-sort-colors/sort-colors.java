class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> colorToCount = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            colorToCount.put(
                nums[i],
                colorToCount.getOrDefault(nums[i], 0) + 1
            );
        }

        int index = 0;

        for (int color = 0; color <= 2; color++) {
            int count = colorToCount.getOrDefault(color, 0);

            for (int j = 0; j < count; j++) {
                nums[index] = color;
                index++;
            }
        }

    }
}