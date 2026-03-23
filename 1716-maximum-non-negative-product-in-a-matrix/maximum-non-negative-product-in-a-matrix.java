class Solution {
    static long[][][] dp;
    public long[] solve(int[][] grid,int i,int j){
        //// Recursion.....
        int m = grid.length;
        int n = grid[0].length;

        // base condition...
        if(i == m-1 && j == n-1){
            return new long[]{grid[i][j], grid[i][j]};
        }

        if(dp[i][j][0] != Long.MIN_VALUE){
            return new long[]{dp[i][j][0], dp[i][j][1]};
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        // down....
        if(i+1 < m){
            // index 0 → max
            // index 1 → min
            long[] down = solve(grid,i+1,j);

            long downMax = down[0];
            long downMin = down[1];

            maxVal = Math.max(maxVal, Math.max(grid[i][j] * downMax, grid[i][j] * downMin));
            minVal = Math.min(minVal, Math.min(grid[i][j] * downMax, grid[i][j] * downMin));
        }

        // right...
        if(j + 1 < n){
            long[] right = solve(grid,i,j+1);

            long rightMax = right[0];
            long rightMin = right[1];

            maxVal = Math.max(maxVal, Math.max(grid[i][j] * rightMax, grid[i][j] * rightMin));

            minVal = Math.min(minVal, Math.min(grid[i][j] * rightMax, grid[i][j] * rightMin));
        }

        dp[i][j][0] = maxVal;
        dp[i][j][1] = minVal;

        return new long[]{maxVal,minVal};
    }
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new long[m][n][2];  // for negative value....
        for(long[][] row : dp){
            for(long[] cell : row){
                Arrays.fill(cell, Long.MIN_VALUE);
            }
        }
        long[] res = solve(grid,0,0);
        long max = res[0];

        return max < 0 ? -1 : (int)(max % 1000000007);
    }
}