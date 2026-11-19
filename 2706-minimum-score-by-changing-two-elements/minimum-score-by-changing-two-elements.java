class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        // therefore answer = min(highScore)
        // two smallest ko change kro...
        int case1 = nums[n-1] - nums[2];
        // one smallest and one largest
        int case2 = nums[n-2] - nums[1];
        // two largest element
        int case3 = nums[n-3] - nums[0];

        return Math.min(case1,Math.min(case2, case3));
    }
}