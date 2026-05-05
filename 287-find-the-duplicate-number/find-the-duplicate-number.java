class Solution {
    public int findDuplicate(int[] nums) {
        // jispe bhi 2 arrow jayega na wahi jimmedar hoga cycle banane me...and wahi repeated element hoga...(starting point)
        // cycle find kro and cycle ka starting point khojo..
        int slow = 0;
        int fast = 0;

        // detect cycle
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if(slow == fast){
                slow = 0;

                while(slow != fast){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}