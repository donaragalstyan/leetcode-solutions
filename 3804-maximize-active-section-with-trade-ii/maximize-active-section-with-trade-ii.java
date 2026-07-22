class Solution {
    private int[] segmentTree;
    private int pairCount;

    public List<Integer> maxActiveSectionsAfterTrade(
        String s,
        int[][] queries
    ) {
        int n = s.length();
        int totalOnes = 0;

        List<Integer> startsList = new ArrayList<>();
        List<Integer> endsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                continue;
            }

            int start = i;

            while (i + 1 < n && s.charAt(i + 1) == '0') {
                i++;
            }

            startsList.add(start);
            endsList.add(i);
        }

        int zeroRunCount = startsList.size();

        int[] starts = new int[zeroRunCount];
        int[] ends = new int[zeroRunCount];
        int[] lengths = new int[zeroRunCount];

        for (int i = 0; i < zeroRunCount; i++) {
            starts[i] = startsList.get(i);
            ends[i] = endsList.get(i);
            lengths[i] = ends[i] - starts[i] + 1;
        }
        pairCount = Math.max(0, zeroRunCount - 1);

        if (pairCount > 0) {
            int[] pairGains = new int[pairCount];

            for (int i = 0; i < pairCount; i++) {
                pairGains[i] = lengths[i] + lengths[i + 1];
            }

            segmentTree = new int[pairCount * 4];
            build(pairGains, 1, 0, pairCount - 1);
        }

        List<Integer> answer = new ArrayList<>(queries.length);

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            int firstRun = lowerBound(ends, left);

            int lastRun = upperBound(starts, right) - 1;
            if (firstRun >= zeroRunCount || lastRun < 0 || firstRun >= lastRun) {
                answer.add(totalOnes);
                continue;
            }

            int firstLength =
                Math.min(ends[firstRun], right)
                - Math.max(starts[firstRun], left)
                + 1;

            int lastLength =
                Math.min(ends[lastRun], right)
                - Math.max(starts[lastRun], left)
                + 1;

            int bestGain = 0;

            if (firstRun + 1 == lastRun) {
                bestGain = firstLength + lastLength;
            } else {
                bestGain = Math.max(
                    bestGain,
                    firstLength + lengths[firstRun + 1]
                );


                bestGain = Math.max(
                    bestGain,
                    lengths[lastRun - 1] + lastLength
                );

                int interiorLeft = firstRun + 1;
                int interiorRight = lastRun - 2;

                if (interiorLeft <= interiorRight) {
                    bestGain = Math.max(
                        bestGain,
                        rangeMax(
                            1,
                            0,
                            pairCount - 1,
                            interiorLeft,
                            interiorRight
                        )
                    );
                }
            }

            answer.add(totalOnes + bestGain);
        }

        return answer;
    }

    private void build(int[] values, int node, int left, int right) {
        if (left == right) {
            segmentTree[node] = values[left];
            return;
        }

        int middle = left + (right - left) / 2;

        build(values, node * 2, left, middle);
        build(values, node * 2 + 1, middle + 1, right);

        segmentTree[node] = Math.max(
            segmentTree[node * 2],
            segmentTree[node * 2 + 1]
        );
    }

    private int rangeMax(
        int node,
        int left,
        int right,
        int queryLeft,
        int queryRight
    ) {
        if (queryLeft <= left && right <= queryRight) {
            return segmentTree[node];
        }

        int middle = left + (right - left) / 2;
        int result = 0;

        if (queryLeft <= middle) {
            result = Math.max(
                result,
                rangeMax(
                    node * 2,
                    left,
                    middle,
                    queryLeft,
                    queryRight
                )
            );
        }

        if (queryRight > middle) {
            result = Math.max(
                result,
                rangeMax(
                    node * 2 + 1,
                    middle + 1,
                    right,
                    queryLeft,
                    queryRight
                )
            );
        }

        return result;
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}