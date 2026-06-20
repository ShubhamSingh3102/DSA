class Solution {
    public int[] sortedSquares(int[] nums) {
        // TC --> O(n)
        // SC --> O(n)
        int n = nums.length;
        int[] res = new int[n];

//      Sabse bada square hamesha -->   left end ya right end

        int left = 0;
        int right = n - 1;
        int k = n - 1;

        while(left <= right){
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];

            // 16 > 100 ??
            if(l > r){
                res[k--] = l;
                left++;
            } else {
                res[k--] = r;
                right--;
            }
        }
        return res;
    }
}