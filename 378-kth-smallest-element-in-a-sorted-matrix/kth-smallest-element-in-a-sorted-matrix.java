class Solution {
    public int find(int[][] matrix, int mid){
        int n = matrix.length;
        int m = matrix[0].length;

        int row = n - 1;
        int col = 0;
        int count = 0;
        while(row >= 0 && col < m){
            if(matrix[row][col] <= mid){
                count += row + 1;
                col++;
            } else {
                 row--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        int res = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            // kitne element guess se chote hai...
            int ans = find(matrix,mid);
            if(ans < k){
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
}