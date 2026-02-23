class Solution {
    public int binaryGap(int n) {
        int prev = -1; //// previous 1 position
        int maxGap = 0;
        int curr = 0; //// current bit position

        while (n > 0) {
            if ((n & 1) > 0) {   //// set bit
                maxGap = (prev != -1) ? Math.max(maxGap, curr - prev) : maxGap;
                prev = curr;
            }
            curr++;
            n >>= 1; // right shift
        }
        return maxGap;
    }
}