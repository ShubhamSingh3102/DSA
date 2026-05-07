class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int minEnding = 0;
        int maxEnding = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            minEnding = Math.min(nums[i], minEnding + nums[i]);

            ans = Math.max(ans,Math.max(Math.abs(maxEnding), Math.abs(minEnding)));
        }
        return ans;
    }
}