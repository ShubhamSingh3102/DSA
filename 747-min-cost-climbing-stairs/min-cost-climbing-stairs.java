class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0, prev2 = 0;
        for (int i = 0; i < cost.length; i++) {
            int curr = Math.min(prev + cost[i], prev2 + cost[i]);
            prev2 = prev;
            prev = curr;
        }
        return Math.min(prev, prev2);
    }
}