class Solution {
    public void find(int[] candidates,int n, int idx, List<Integer> diary, int sum, List<List<Integer>> res, int target){
        if(idx == n){
            if(sum == target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }

        // 2 choice hai....
        // nhi lena hai...
        find(candidates,n,idx+1,diary,sum,res,target);

        // lena hai
        if(candidates[idx] + sum <= target){
            // le skte hai...
            diary.add(candidates[idx]);
            sum += candidates[idx];  // sum ko bhi update kr dijia

            find(candidates,n,idx,diary,sum,res,target);

            // backtrack
            diary.remove(diary.size() - 1);
            sum -= candidates[idx];
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;

        find(candidates,n,0,diary,0,res,target);

        return res;
    }
}