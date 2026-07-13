class Solution {
    public int TotalSum(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right;
        for(int i = 0; i < n; i++){
            right = TotalSum(nums) - left - nums[i];

            if(left == right){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}