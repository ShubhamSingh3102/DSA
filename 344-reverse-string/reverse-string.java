class Solution {
     public void reverse(char[] arr, int i, int j) {

        int len = j - i + 1;
        
        if (len == 0 || len == 1) {
            return;
        }

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i + 1, j - 1);
    }
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }
}