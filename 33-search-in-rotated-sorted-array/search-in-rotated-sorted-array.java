class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[n - 1]) { // part 1
                if (nums[mid] < target) { // right jaana h
                    low = mid + 1;
                } else { // nums[mid] > target
                    if (nums[0] > target) { // part 1 ka sabse chota element
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else { // part 2
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    if (nums[n - 1] < target) {
                        // left
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}