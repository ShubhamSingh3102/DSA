class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    public void build(int[] nums, int i, int l, int r) {
        if (l == r) {
            tree[i] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(nums, 2 * i + 1, l, mid);
        build(nums, 2 * i + 2, mid + 1, r);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public int querySegmentTree(int start, int end, int i, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }

        if (l >= start && r <= end) {
            return tree[i];
        }

        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * i + 1, l, mid) +
                querySegmentTree(start, end, 2 * i + 2, mid + 1, r);
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */