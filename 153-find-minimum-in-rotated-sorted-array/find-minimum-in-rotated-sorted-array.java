class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[n - 1]){  // part 2
                low = mid + 1;
            } else {   // part 1
                ans = nums[mid];
                high = mid - 1;
            }
        }
        return ans;
    }
}