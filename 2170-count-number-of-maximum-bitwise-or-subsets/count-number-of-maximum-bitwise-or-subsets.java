class Solution {
    public static List<List<Integer>> findSubsets(int[] nums){
        int n = nums.length;

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < (1 << n); i++){

            List<Integer> subset = new ArrayList<>();

            for(int j = 0; j < n; j++){
                // Check whether the j-th bit of i is set (1) or not....
                if((i & (1 << j)) != 0){
                    subset.add(nums[j]);
                }
            }
            list.add(subset);
        }
        return list;
    }
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        int max = 0;
        int count = 0;

        List<List<Integer>> list = findSubsets(nums);

        for(int i = 0; i < list.size(); i++){

            int or = 0;

            for(int j = 0; j < list.get(i).size(); j++){

                or = or | list.get(i).get(j);
            }

            if(or > max){
                max = or;
                count = 1;
            }
            else if(or == max){
                count++;
            }
        }
        return count;
    }
}