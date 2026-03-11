class Solution {
    public int bitwiseComplement(int n) {
        // TC ---> O(log2n)
        // SC ---> O(1)
        // find mask
        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1; // first left shift and then or with 1....
        }
        return mask ^ n;
    }
}