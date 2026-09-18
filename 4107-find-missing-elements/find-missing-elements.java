class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int smallest = nums[0];
        int largest = nums[0];

        for(int i =0; i < nums.length; i++){
            smallest = Math.min(smallest,nums[i]);
            largest = Math.max(largest,nums[i]);
        }

        for(int i = smallest; i <= largest; i++){
            map.put(i,0);
        }

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int x: map.keySet()){
            if(map.get(x) == 0){
                ans.add(x);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}