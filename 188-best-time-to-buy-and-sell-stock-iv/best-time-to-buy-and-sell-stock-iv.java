class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // after and cur arrays (like screenshot)
        int[][] after = new int[2][k+1];
        int[][] cur = new int[2][k+1];


        int profit;

        for(int ind = n-1 ; ind >= 0; ind--){
            for(int buy = 0 ; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    if(buy == 1) {
                        int take = -prices[ind] + after[0][cap];
                        int notTake = after[1][cap];
                        cur[buy][cap] = Math.max(take, notTake);
                    }else { // sell
                        int take = +prices[ind] + after[1][cap-1];
                        int notTake = after[0][cap];
                        cur[buy][cap]  = Math.max(take, notTake);
                    }
                }
            }
            // move cur → after....
            for (int i = 0; i < 2; i++) {
                after[i] = cur[i].clone();
            }
        }
        return after[1][k];
    }
}