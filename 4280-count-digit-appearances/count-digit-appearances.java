class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            while(nums[i] > 0){
                int d = nums[i] % 10;
                if(d == digit){
                    count++;
                }
                nums[i] = nums[i] / 10;
            }
        }
        return count;
    }
}