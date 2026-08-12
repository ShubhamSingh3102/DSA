class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int low = 0;
        int high = 0;
        int res = Integer.MIN_VALUE;


        for(high = 0; high < nums.length; high++){

            // Expand window....
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            // Shrink Window....
            while (low < high && map.get(nums[high]) > k){
               map.put(nums[low], map.get(nums[low]) - 1);

                if(map.get(nums[low]) == 0){
                    map.remove(nums[low]);
                }
                low++;
            }

            res = Math.max(res, high - low + 1);
        }
        return res;
    }
}