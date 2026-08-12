class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int low = 0;
        int high = 0;
        int res = Integer.MIN_VALUE;
        int culprit = 0;

        for (high = 0; high < nums.length; high++) {

            // Expand window....
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            if (map.get(nums[high]) == k + 1) {
                culprit++;
            }

            if (culprit > 0) {
                map.put(nums[low], map.get(nums[low]) - 1);
                if (map.get(nums[low]) == k) {
                    culprit--;
                }
                low++;
            }

            // valid subArray...
            if (culprit == 0) {
                res = Math.max(res, high - low + 1);
            }
        }
        return res;
    }
}