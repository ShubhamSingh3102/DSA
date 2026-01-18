class Solution {
    public static boolean checkMagicNumber(int[][] grid, int i, int j, int k) {
        int target = 0;

        // for finding target ---> traversing col....
        for (int c = j; c < j + k; c++) {
            target += grid[i][c];
        }

        // iterating row...for row sum....
        for (int row = i; row < i + k; row++) {
            int sum = 0;
            for (int col = j; col < j + k; col++) {
                sum += grid[row][col];
            }
            if (sum != target) {
                return false;
            }
        }

        // iterating col...for col sum....
        for (int col = j; col < j + k; col++) {
            int sum = 0;
            for (int row = i; row < i + k; row++) {
                sum += grid[row][col];
            }
            if (sum != target) {
                return false;
            }
        }

        int sum = 0;

        // iterating diagonal...for diagonal sum....
        for (int p = 0; p < k; p++) {
            sum += grid[i + p][j + p];
        }
        if (sum != target) {
            return false;
        }

        // iterating anti-diagonal...for anti-diagonal sum...
        sum = 0;
        for (int p = 0; p < k; p++) {
            sum += grid[i + p][j + k - 1 - p];
        }
        if (sum != target) {
            return false;
        }
        return true;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // k = 1...hamesha magic square hoga...isiliye k = 2 se chalu hai...
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= m - k; j++) {
                    if (checkMagicNumber(grid, i, j, k)) { // if it is true then maxi....
                        // maxi = Math.max(k,maxi);
                        return k;
                    }
                }
            }
        }
        return 1;
    }
}