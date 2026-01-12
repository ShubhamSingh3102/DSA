class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int[] dp = new int[n];

        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];

            int time = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            dp[i] = time + dp[i+1];
        }
        return dp[0];
    }
}