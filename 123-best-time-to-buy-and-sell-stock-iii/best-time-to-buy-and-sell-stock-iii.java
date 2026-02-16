class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

       int[][][] dp = new int[n+1][2][3];

       // cap == 0
       for(int ind = 0; ind < n; ind++ ){
           for(int buy = 0 ; buy <= 1; buy++){
               dp[ind][buy][0] = 0;
           }
       }

       // ind == n
       for(int buy = 0 ; buy <= 1; buy++){
           for(int cap = 0 ; cap <= 2; cap++){
               dp[n][buy][cap] = 0;
           }
       }
       int profit;

       for(int ind = n-1 ; ind >= 0; ind--){
           for(int buy = 0 ; buy <= 1; buy++){
               for(int cap = 1; cap <= 2; cap++){
                   if(buy == 1) {
                       int take = -prices[ind] + dp[ind+1][0][cap];
                       int notTake = dp[ind+1][1][cap];
                       dp[ind][buy][cap] = Math.max(take, notTake);
                   }else { // sell
                       int take = +prices[ind] + dp[ind+1][1][cap-1];
                       int notTake = dp[ind+1][0][cap];
                       dp[ind][buy][cap]  = Math.max(take, notTake);
                   }
               }
           }
       }
       return dp[0][1][2];
    }
}