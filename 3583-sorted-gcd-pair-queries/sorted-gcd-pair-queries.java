class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] frequency = new int[max + 1];

        for (int num : nums) {
            frequency[num]++;
        }

        // gcdCount[g] = number of pairs whose GCD is exactly g
        long[] gcdCount = new long[max + 1];

        for (int gcd = max; gcd >= 1; gcd--) {
            long divisibleCount = 0;

            for (int multiple = gcd; multiple <= max; multiple += gcd) {
                divisibleCount += frequency[multiple];
            }

            // All pairs where both values are divisible by gcd
            gcdCount[gcd] = divisibleCount * (divisibleCount - 1) / 2;

            // Remove pairs whose GCD is a larger multiple of gcd
            for (int multiple = gcd * 2; multiple <= max; multiple += gcd) {
                gcdCount[gcd] -= gcdCount[multiple];
            }
        }

        // Convert into cumulative counts representing sorted gcdPairs
        for (int gcd = 1; gcd <= max; gcd++) {
            gcdCount[gcd] += gcdCount[gcd - 1];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long targetIndex = queries[i];

            int left = 1;
            int right = max;

            while (left < right) {
                int middle = left + (right - left) / 2;

                // queries use zero-based indexing
                if (gcdCount[middle] > targetIndex) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }

            answer[i] = left;
        }

        return answer;
    }
}