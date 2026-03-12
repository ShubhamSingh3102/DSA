class Solution {
    public int bitwiseComplement(int n) {
        // TC ---> O(log2n)
        // SC ---> O(1)
        // find mask
        // int mask = 1;
        // while (mask < n) {
        //     mask = (mask << 1) | 1; // first left shift and then or with 1....
        // }
        // return mask ^ n;
        if(n == 0) {
            return 1;
        }
        // find number of bit required to represent the number n...
        int bits = (int)(Math.floor(Math.log(n) / Math.log(2))) +1;
        int mask = (int) (Math.pow(2,bits) - 1);
        return mask ^ n;
    }
}