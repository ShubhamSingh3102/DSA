class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        // Base case: last row
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Build from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            cur = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = (int) -1e9;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {

                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                if (j1 == j2)
                                    maxi = Math.max(maxi,grid[i][j1] + front[nj1][nj2]);
                                else
                                    maxi = Math.max(maxi,grid[i][j1] + grid[i][j2] + front[nj1][nj2]);
                            }
                        }
                    }
                    cur[j1][j2] = maxi;
                }
            }
            front = cur;
        }
        // start positions
        return front[0][m - 1];
    }
}