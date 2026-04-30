class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Variable Sliding Window...

        // hiring and firing system in amazon...
        // always in variable window size...window length = 1
        int low = 0;
        int high = 0;

        int result = Integer.MAX_VALUE;
        int sum = 0;

        // hiring ---> high ke taraf se
        // firing ---> low ke taraf se

        while (high < nums.length) {
            sum = sum + nums[high];

            // jab tk kaam ho rha h...
            while (sum >= target) { // kaam ho rha h....
                int length = high - low + 1;
                result = Math.min(result, length);

                // now fire kro
                sum = sum - nums[low];
                low++;
            }
            high++;
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}