class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        //// Tabulation way....
        // s1 finished → delete rest of s2
        //// base case....
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];


        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + s2.charAt(j);
        }

        // base case: s2 finished → delete rest of s1
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + s1.charAt(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j], s2.charAt(j) + dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}