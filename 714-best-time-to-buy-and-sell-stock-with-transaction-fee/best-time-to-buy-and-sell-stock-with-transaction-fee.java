class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[] prev = new int[2]; // ahead
        int[] curr = new int[2]; // current

        for (int ind = n - 1; ind >= 0; ind--) {

            // buy = 1
            curr[1] = Math.max(-prices[ind] + prev[0],
                    prev[1]);

            // buy = 0
            curr[0] = Math.max((prices[ind] - fee ) + prev[1],
                    prev[0]);

            // shift
            prev = curr.clone();
        }

        return prev[1];
    }
}