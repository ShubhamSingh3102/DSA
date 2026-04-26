class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0; // officer
        int unique = 1; // count
        int j = 1; // cm

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++; // skip duplicate
            } else {
                nums[i + 1] = nums[j];
                i++;
                unique++;
                j++;
            }
        }
        return unique;
    }
}