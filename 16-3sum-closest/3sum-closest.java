class Solution {
    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        int max_diff = Integer.MAX_VALUE;
        int result_sum = 0;

        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++){

            int left = i + 1;
            int right = n - 1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];

                int diff = Math.abs(sum - target);

                // chota closest mila...
                if(diff < max_diff){
                    max_diff = diff;
                    result_sum = sum;
                }

                if(sum < target){
                    left++;
                } else if(sum > target){
                    right--;
                } else {   // best case...
                    return sum;
                }
            }
        }
        return result_sum;
    }
}