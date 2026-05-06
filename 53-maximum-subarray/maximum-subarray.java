class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int bestEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int v1 = bestEnding + nums[i]; // purane waale se saath journey continue kr rhe h
            int v2 = nums[i]; // fresh start kr rha hu...
            bestEnding = Math.max(v1, v2);
            ans = Math.max(ans, bestEnding);
        }
        return ans;
    }
}