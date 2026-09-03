class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < weights.length; ++i) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }


        while (low < high) {
            int middle = low + (high - low) / 2;

            if (canShip(weights, days, middle)) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int daysUsed = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysUsed++;
                currentLoad = 0;
            }

            currentLoad += weight;
        }

        return daysUsed <= days;
    }
}