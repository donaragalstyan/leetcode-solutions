class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxTotal = 0;

        HashMap<Integer, Integer> fruitToCount = new HashMap<>();

        for (int right = 0; right < fruits.length; ++right) {

            fruitToCount.put(fruits[right], fruitToCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitToCount.size() > 2) {

                int fruitLeaving = fruits[left];

                fruitToCount.put(
                    fruitLeaving,
                    fruitToCount.get(fruitLeaving) - 1
                );

                if (fruitToCount.get(fruitLeaving) == 0) {
                    fruitToCount.remove(fruitLeaving);
                }

                left++;
            }

            maxTotal = Math.max(maxTotal, right - left + 1);
        }

        return maxTotal;
    }
}