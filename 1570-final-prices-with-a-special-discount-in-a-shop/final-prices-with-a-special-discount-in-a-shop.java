class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        int n = prices.length;
        for(int i=0;i<n;i++){
            ans[i] = prices[i];
            for(int j=i+1;j<n;j++){
                if(prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}