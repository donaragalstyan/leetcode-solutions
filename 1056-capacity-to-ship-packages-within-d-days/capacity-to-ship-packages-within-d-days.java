class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < weights.length; ++i) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        int middle = 0;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (canShip(weights, days, middle)) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        return low;
    }


    private boolean canShip(int[] weight, int days, int w) {
        int currDay = 1;
        int total = 0;
        for (int i = 0; i < weight.length; ++i) {
            if (total + weight[i] > w) {
                currDay++;
                total = 0;
            }

            total += weight[i];

            if (currDay > days) {
                return false;
            }
        }

        return true;
    }
}