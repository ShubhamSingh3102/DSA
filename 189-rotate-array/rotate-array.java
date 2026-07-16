class Solution {
    public void reverseSection(int[] nums, int start, int end){

        // reverse whole group
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        if (k == 0){
            return;
        }

        // reverse first k element
        reverseSection(nums,0,n-k-1);

        // reverse remaining n - k element
        reverseSection(nums, n-k, n-1);

        // reverse whole array
        reverseSection(nums,0, n-1);
    }
}