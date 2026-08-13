class Solution {
    public static long findHour(int[] piles,int speed){
        int n = piles.length;
        long hour = 0;
        for(int i = 0; i < n; i++){
            hour = hour + (piles[i] /speed);

            if(piles[i] % speed != 0){
                hour++;
            }
        }
        return hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int high = piles[0];  // max of array...

        for(int i = 0; i < n; i++){
            high = Math.max(piles[i],high);
        }

        int res = -1;
        while(low<= high){
            int mid = low + (high - low) / 2;
            long hour = findHour(piles,mid);

            if(hour > h){   // no
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
}