class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int[] ans = new int[n];

        // index maintain krne ke liye
        int r = 0;
        int a = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < pivot){
                res[r] = nums[i];
                r++;
            } else if(nums[i] > pivot) {
                ans[a] = nums[i];
                a++;
            }
        }

        int pivotCount = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == pivot){
                pivotCount++;
            }
        }

        int[] finalAns = new int[n];
        int index = 0;

        // Add smaller elements
        for(int i = 0; i < r; i++){
            finalAns[index] = res[i];
            index++;
        }

        // Add pivot element
        for(int i = 0; i < pivotCount; i++){
            finalAns[index] = pivot;
            index++;
        }

        // Add larger element
        for(int i = 0; i < a; i++){
            finalAns[index] = ans[i];
            index++;
        }
        return finalAns;
    }
}