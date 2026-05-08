class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        int left = 0;
        int right;
        for(int i = 0; i < n; i++){
            right = totalSum - left - nums[i];

            if(left == right){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}