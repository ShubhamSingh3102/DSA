class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];

        for(int t =0; t <= amount; t++){
            if(t % coins[0] == 0){
                prev[t] = t/coins[0];
            }
            else{
                prev[t] =  (int)1e9;
            }
        }
        for(int index = 1;index <= n-1;index++){
            for(int t = 0; t <= amount; t++){
                int notTake = prev[t];
                int take = Integer.MAX_VALUE;
                if(coins[index] <= t){
                    take = 1 + curr[t - coins[index]];
                }
                curr[t] = Math.min(take,notTake);
            }
            prev = curr.clone();
        }
        return prev[amount] >= (int)1e9 ? -1 : prev[amount];
    }
}