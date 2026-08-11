class Solution {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int k = 0; k < nums.length; k++){
            map.put(nums[k],1);
        }
        for(int i = 1; i < nums.length; i++){

            // kyuki adjacent dekhna hai....
            if (nums[i] == nums[i-1] + 1){
                prefixSum += nums[i];
            } else {
                break;
            }
        }
        while (map.containsKey(prefixSum)){
            prefixSum++;
        }
        return prefixSum;
    }
}