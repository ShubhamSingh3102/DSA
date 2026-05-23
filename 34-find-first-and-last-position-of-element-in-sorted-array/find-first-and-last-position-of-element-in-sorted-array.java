class Solution {
    public int first_position(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else { // nums[mid] == target
                     // first dukan ke liye
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public int last_position(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else { // nums[mid] == target
                     // last dukan ke liye
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = first_position(nums, target);
        int last = last_position(nums, target);

        return new int[] { first, last };
    }
}