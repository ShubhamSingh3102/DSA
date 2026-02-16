class Solution {
    public int reverseBits(int n) {
        if(n == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0;i < 32; i++){
            result <<= 1;  // jagah banao....

            result = (result | (n & 1));
            // result me append kr do...

            n >>= 1;
        }
        return result;
    }
}