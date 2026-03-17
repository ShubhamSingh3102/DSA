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
            tree[i] = nums[r];
            return;
        }
        int mid = (l + r) / 2;
        build(nums, 2 * i + 1, l, mid);
        build(nums, 2 * i + 2, mid + 1, r);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, 0, n - 1);
    }

    public void updateSegmentTree(int idx, int val, int i, int l, int r) {
        if (l == r) {
            tree[i] = val;
            return;
        }

        int mid = (l + r) / 2;
        if (idx <= mid) { // left child
            updateSegmentTree(idx, val, 2 * i + 1, l, mid);
        } else { // right child
            updateSegmentTree(idx, val, 2 * i + 2, mid + 1, r);
        }
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public int sumRange(int left, int right) {
        return query(left, right, 0, 0, n - 1);
    }

    public int query(int start, int end, int i, int l, int r) {
        if (l > end || r < start) { // out of bound
            return 0;
        }
        if (l >= start && r <= end) {
            return tree[i];
        }
        int mid = (l + r) / 2;

        int leftSum = query(start, end, 2 * i + 1, l, mid);
        int rightSum = query(start, end, 2 * i + 2, mid + 1, r);

        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */