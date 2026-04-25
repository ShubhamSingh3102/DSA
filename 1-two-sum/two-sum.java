class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n ; i++){
            int pair = target - nums[i];

            if(map.containsKey(pair)){
                return new int[]{map.get(pair), i};
            }
            // if not present in map put the element in map...
            map.put(nums[i],i);
        }
        // if no solution then
        return new int[]{-1,-1};
    }
}