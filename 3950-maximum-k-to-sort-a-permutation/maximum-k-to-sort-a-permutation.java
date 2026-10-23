class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int count = -1;

        boolean sorted = true;


        // already sorted...
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                sorted = false;
                break;
            }
        }

        if(sorted){
            return 0;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i){
                if(count == -1){
                    count = nums[i];
                } else {
                    count = count & nums[i];
                }
            }
        }
        return count;
    }
}