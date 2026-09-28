class Solution {
    public boolean canAliceWin(int[] nums) {
        int[] singleDigit = new int[nums.length];
        int[] doubleDigit = new int[nums.length];


        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 10){
                singleDigit[i] = nums[i];
            } else {
                doubleDigit[i] = nums[i];
            }
        }

        int sumOfSingleDigit = 0;
        for(int i = 0; i < singleDigit.length; i++){
            sumOfSingleDigit += singleDigit[i];
        }

        int sumOFDoubleDigit = 0;
        for(int i = 0; i < doubleDigit.length; i++){
            sumOFDoubleDigit += doubleDigit[i];
        }

        if(sumOfSingleDigit == sumOFDoubleDigit){
            return false;
        } else {
            return true;
        }
    }
}