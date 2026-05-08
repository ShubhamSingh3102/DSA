class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        // (sum - k) ko kitna baar dekha tumne...
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;

        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int ques = sum - k; // prefix sum store krta hai...
            int freq = map.getOrDefault(ques, 0);

            res += freq;

            // prefixSum ---> frequency...
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}