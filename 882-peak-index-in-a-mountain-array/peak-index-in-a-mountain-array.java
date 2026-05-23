class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int low = 0;

        for(int i = 1; i < arr.length; i++){
            int high = i;
            if(arr[low] < arr[high]){
                low ++;
                high ++;
            } else {
                return low;
            }
        }
        return low;
    }
}