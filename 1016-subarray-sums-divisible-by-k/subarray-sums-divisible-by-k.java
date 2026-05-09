class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int res = 0;

        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int rem = sum % k;

            // negative remainder fix
            if (rem < 0) {
                rem += k;
            }

            int freq = map.getOrDefault(rem, 0);

            res += freq;

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}