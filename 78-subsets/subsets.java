class Solution {
     public void find(int[] nums,int idx,ArrayList<Integer> temp, List<List<Integer>> ans){
        int n = nums.length;

        if(idx == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // nhi lenge(aage badho)
        find(nums,idx+1,temp,ans);

        // lena hai
        temp.add(nums[idx]);
        find(nums,idx+1,temp,ans);

        // reverse kr do aapne decision ko...
        temp.remove(temp.size() - 1);
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        int idx = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        find(nums,idx,temp,ans);

        return ans;
    }
}