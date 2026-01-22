class Solution {
    public static int checkSorted(int[] nums){
        for(int i = 1; i < nums.length;i++){
            if(nums[i] < nums[i-1]){ // not sorted
                return 1;
            }
        }
        return 0;
    }
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;

        if(checkSorted(nums) == 0){
            return 0;
        }
        while(checkSorted(nums) != 0){

            int min = Integer.MAX_VALUE;
            int index = -1;

            // find minimum adjacent pair sum
            for(int i = 0; i < nums.length - 1; i++){
                int sum = nums[i] + nums[i+1];
                if(sum < min){
                    min = sum;
                    index = i;
                }
            }

            // build new array after removal
            int[] newArr = new int[nums.length - 1];
            int k = 0;

            for(int i = 0; i < nums.length; i++){
                if(i == index){
                    newArr[k++] = min;
                    i++; // skip next element
                } else {
                    newArr[k++] = nums[i];
                }
            }

            nums = newArr; // now nums point to the new array...
            operations++;
        }
        return operations;
    }
}