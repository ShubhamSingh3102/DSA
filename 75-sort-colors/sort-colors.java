class Solution {
    public void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public void sortColors(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;
        while(mid<=high){ 

            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }
}