class Solution {
    void TransposeMatrix(int[][] matrix,int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // row reverse...
    void reverseMatrix(int[] matrix,int n) {
        int i = 0,j = n-1;
        while (i < j) {
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        // because 90*4 = 360
        for(int c = 1; c <= 4; c++){   // O(1)

            boolean equal = true;
            for(int i = 0; i < n; i++){   // O(n^2)
                for(int j = 0; j < n; j++){
                    if(mat[i][j] != target[i][j]){
                        equal = false;
                        break;
                    }
                }
                if(!equal){
                    break;
                }
            }
            if(equal){
                return true;
            }
            // rotate 90 degree
            TransposeMatrix(mat,n);  // O(n^2)
            for(int i = 0; i < n; i++){
                reverseMatrix(mat[i],n); // reverse each row...
            }
        }
        return false;
    }
}