class Solution {
    public int concatenatedBinary(int n) {
        int M = (int) 1e9 + 7;
        long result = 0;

        for (int num = 1; num <= n; num++) {
            int digits = (int) (Math.log(num) / Math.log(2)) + 1;

            result = ((result << digits) % M + num) % M;
        }
        return (int) result;
    }
}