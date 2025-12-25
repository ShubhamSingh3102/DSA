class Solution {
    int solve(int i, int[] height, int[] dp) {
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];

        int oneJump = solve(i - 1, height, dp)
                      + Math.abs(height[i] - height[i - 1]);

        int twoJump = Integer.MAX_VALUE;
        if (i > 1) {
            twoJump = solve(i - 2, height, dp)
                      + Math.abs(height[i] - height[i - 2]);
        }

        return dp[i] = Math.min(oneJump, twoJump);
    }

    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, height, dp);
    }
}
