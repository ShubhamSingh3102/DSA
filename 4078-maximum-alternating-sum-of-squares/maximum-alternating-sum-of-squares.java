class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[] squares = new long[n];

        // Pehle har number ka square kar do
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long sum = 0;

        // smallest half;
        for(int i = 0; i < n / 2; i++){
            sum -= squares[i];
        }

        // largest half....
        for(int i = n / 2; i < n; i++){
            sum += squares[i];
        }

        return sum;
    }
}