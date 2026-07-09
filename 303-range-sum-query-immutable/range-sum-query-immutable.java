class NumArray {
    private int[] nums;
    private int[] prefixSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int[nums.length];
        this.prefixSum[0] = this.nums[0];
        for (int i = 1; i < this.nums.length; ++i) {
            this.prefixSum[i] = this.prefixSum[i-1] + this.nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.prefixSum[right];
        }

        return prefixSum[right] - prefixSum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */