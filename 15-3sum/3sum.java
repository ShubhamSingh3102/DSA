class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // TC --> 0(n^2)
        // SC --> O(1)
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // first sort
        Arrays.sort(nums); // n log n

        // i != left and left != right and right != i
        for (int i = 0; i < n - 2; i++) { // kyuki (n - 2) ke baad 2 pair chahiye na sum krne ke liye...O(n-2)

            // duplicate i skip...
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // O(n)
            int left = i + 1;
            int right = n - 1;

            int sum = -1 * nums[i]; // because i + left + right = 0
            while (left < right) {
                int s = nums[left] + nums[right];
                if (s == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // duplicate left skip
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // duplicate right skip
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // else
                    left++;
                    right--;
                } else if (s < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}