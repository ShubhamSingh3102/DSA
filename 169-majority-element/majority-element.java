class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        int maxElement = 0;
        for(int a : map.keySet()){
            if(map.get(a) > max){
                max = map.get(a);
                maxElement = a;
            }
        }
        return maxElement;
    }
}