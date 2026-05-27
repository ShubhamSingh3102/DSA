class Solution {
    public long findHour(int[] piles, int speed){
        long hour = 0;
        for(int i = 0; i < piles.length; i++){
            hour += (piles[i] + speed - 1) / speed;
        }
        return hour;
    }

    public int minEatingSpeed(int[] piles, int h){
        int low = 1;
        int high = piles[0];

        for(int i = 0; i < piles.length; i++){
            high = Math.max(high, piles[i]);
        }

        int res = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            long hour = findHour(piles, mid);

            if(hour > h){
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }

        return res;
    }
}