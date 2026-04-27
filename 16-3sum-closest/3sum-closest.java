class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // TC --> 0(n^2)
        // SC --> O(1)
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int max_diff = Integer.MAX_VALUE;
        int result_sum = 0;

        // first sort
        Arrays.sort(nums); // n log n

        // i != left and left != right and right != i
        for (int i = 0; i < n - 2; i++) { // kyuki (n - 2) ke baad 2 pair chahiye na sum krne ke liye...O(n-2)

            // O(n)
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                int diff = Math.abs(sum - target);

                if (diff < max_diff) {
                    max_diff = diff;
                    result_sum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return result_sum;
    }
}