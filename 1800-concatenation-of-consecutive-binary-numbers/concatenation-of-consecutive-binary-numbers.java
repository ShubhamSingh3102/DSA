class Solution {
    public int concatenatedBinary(int n) {
       int M = (int) 1e9 + 7;
        int digits = 0;
        long result = 0;

        for(int num = 1; num <= n; num++){
            if((num & (num -1)) == 0){
                digits++;
            }
            result = ((result << digits) % M + num) % M;
        }
        return (int) result;
    }
}