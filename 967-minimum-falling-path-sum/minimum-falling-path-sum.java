class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[m];
        int[] curr = new int[m];

        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j]; // Base Case
        }
        for (int i = 1; i < n; i++) {
            curr = new int[m];  
            for (int j = 0; j < m; j++) {
                int st = matrix[i][j] + prev[j];
                int ld = (int) 1e9;
                if (j - 1 >= 0) {
                    ld = matrix[i][j] + prev[j - 1];
                }
                int rd = (int) 1e9;
                ;
                if (j + 1 < m) {
                    rd = matrix[i][j] + prev[j + 1];
                }
                curr[j] = Math.min(st, Math.min(ld, rd));
            }
            prev = curr;
        }
        int ans = prev[0];
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, prev[j]);
        }
        return ans;
    }
}