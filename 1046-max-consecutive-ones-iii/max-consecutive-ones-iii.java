class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int result = Integer.MIN_VALUE;
        int zeroes = 0;

        while(high < nums.length) {

            if (nums[high] == 0) {
                zeroes++;
            }

            // invalid window...
            while(zeroes > k){
                if(nums[low] == 0){
                    zeroes--;
                }
                low++;
            }
            int len = high - low + 1;
            result = Math.max(result,len);
            high++;
        }
        return result;
    }
}