class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int maxElement = Integer.MIN_VALUE;
            int minElement = Integer.MAX_VALUE;

            for(int j = 0; j <= i; j++){
                maxElement = Math.max(maxElement, nums[j]);
            }

            for(int j = i; j <= n - 1; j++){
                minElement = Math.min(minElement, nums[j]);
            }

            if(maxElement - minElement <= k){
                return i;
            }
        }
        return -1;
    }
}