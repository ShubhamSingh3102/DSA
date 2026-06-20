class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int i = 0;   // officer
        int j = 1;   // cm   --> aage bsdh rha h....

        int unique = 1;   // always unqiue...

        while (j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            } else {
                nums[i+1] = nums[j];
                i++;
                unique++;
                j++;
            }
        }
        return unique;
    }
}