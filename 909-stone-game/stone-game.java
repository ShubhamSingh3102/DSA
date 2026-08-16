class Solution {
    // memoization....
    // Alice ke liye options
    public static int solve(int[] piles,int i, int j, int[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take_i = piles[i] + Math.min(solve(piles,i+2,j,dp), solve(piles,i+1, j-1,dp));

        int take_j = piles[j] + Math.min(solve(piles,i,j-2,dp), solve(piles,i+1,j-1,dp));

        dp[i][j] = Math.max(take_i,take_j);

        return dp[i][j];
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += piles[i];
        }

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        int Alice_Score = solve(piles,0,n-1,dp);
        int bob_Score = sum - Alice_Score;

        if(Alice_Score > bob_Score){
            return true;
        } else {
            return false;
        }
    }
}