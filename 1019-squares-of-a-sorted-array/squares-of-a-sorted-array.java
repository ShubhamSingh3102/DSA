class Solution {
    public int[] sortedSquares(int[] nums) {
        // TC --> O(n)
        // SC --> O(n)
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n - 1;
        int k = n - 1;

        while (left <= right) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];

            if (l > r) {
                res[k--] = l;
                left++;
            } else {
                res[k--] = r;
                right--;
            }
        }
        return res;
    }
}