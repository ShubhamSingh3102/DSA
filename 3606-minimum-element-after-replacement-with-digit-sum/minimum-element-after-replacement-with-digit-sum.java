class Solution {
    public int sumOfDigit(int num) {
        int digitSum = 0;

        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, sumOfDigit(nums[i]));
        }
        return min;
    }
}