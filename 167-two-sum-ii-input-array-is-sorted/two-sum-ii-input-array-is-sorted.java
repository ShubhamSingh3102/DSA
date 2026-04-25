class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 1;
        int j = n;
        while(i < j){
            int sum = numbers[i-1] + numbers[j-1];

            if(sum == target){
                return new int[]{i,j};
            } else if(sum < target){
                i++;
            } else { // sum > target because increasing order...
                j--;
            }
        }
        return new int[]{-1,-1};
    }
}