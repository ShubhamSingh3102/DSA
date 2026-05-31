class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int n = matrix.length;    //row
        int m = matrix[0].length;   // column

        // Bottom left wala
        int row = n - 1;
        int col = 0;

        // TC ---> O(m + n) --> worst case
        while(row >= 0 && col < m){
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target){
                row--;
            } else {
                col++;
            }
        }
        return false; 
    }
}