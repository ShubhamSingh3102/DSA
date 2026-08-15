class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;

        int resultXor = 0;
        boolean allZero = true;

        for (int i = 0; i < n; i++) {
            resultXor = resultXor ^ nums[i];

            // we found at least one element which is non-zero So allZero = false;
            if (nums[i] != 0) {
                allZero = false;
            }
        }

        if (allZero) {
            return 0;
        }

        return (resultXor == 0) ? n - 1 : n;
    }
}