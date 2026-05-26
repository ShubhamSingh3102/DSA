class Solution {
    public int binarySearch(int[] nums,int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
         int n = nums.length;
        int low = 0;
        int high = n - 1;
        int idx = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[n-1]){ // 2d part
                low = mid + 1;
            } else {
                idx = mid;
                high = mid - 1;
            }
        }

        // decide which half to search
        int low1 = 0;
        int high1 = idx -1;

        int low2 = idx;
        int high2 = n - 1;

        // Search in first half
        int ans = binarySearch(nums,low1,high1,target);

        // Search in second half
        if(ans == -1){
            ans = binarySearch(nums,low2,high2,target);
        }
        return ans;
    }
}