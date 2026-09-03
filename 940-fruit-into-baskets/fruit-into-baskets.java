class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruitToCount = new HashMap<>();
        int left = 0;
        int right;
        int maxNum = Integer.MIN_VALUE;
        int curr = 0;

        for (right = 0; right < fruits.length; ++right) {
            fruitToCount.put(fruits[right], fruitToCount.getOrDefault(fruits[right], 0) + 1);
            curr++;

            while (fruitToCount.size() > 2) {
                if (fruitToCount.get(fruits[left]) > 1) {
                    fruitToCount.put(fruits[left], fruitToCount.get(fruits[left])-1);
                } else {
                    fruitToCount.remove(fruits[left]);
                }

                left++;
                curr--;
            }

            maxNum = Math.max(maxNum, curr);
        }


        return maxNum;
        
    }
}