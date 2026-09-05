class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // first find the blue gola
        int gola_index = -1;

        for(int i = n - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                gola_index = i - 1;
                break;
            }
        }

        if(gola_index != -1) {
            // right side me aisa index jo gola_index se baara ho
            int swap_index = gola_index;

            for (int j = n - 1; j >= gola_index + 1; j--) {
                // sabse phela element jo baara h gola_index se...
                if (nums[j] > nums[gola_index]) {
                    swap_index = j;
                    break;
                }
            }

            // swap
            int temp = nums[gola_index];
            nums[gola_index] = nums[swap_index];
            nums[swap_index] = temp;
        }

        // reverse
        int left = gola_index + 1;
        int right = nums.length - 1;

        while (left < right) {
            int temp2 = nums[left];
            nums[left] = nums[right];
            nums[right] = temp2;

            left++;
            right--;
        }
    }
}