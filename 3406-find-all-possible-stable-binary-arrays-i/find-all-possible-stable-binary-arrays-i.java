class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int M = 1_000_000_007;
        int[][][] t = new int[201][201][2];

        // base case....
        t[0][0][0] = 1;
        t[0][0][1] = 1;

        for (int onesLeft = 0; onesLeft <= one; onesLeft++) {
            for (int zeroesLeft = 0; zeroesLeft <= zero; zeroesLeft++) {
                if (onesLeft == 0 && zeroesLeft == 0) {
                    continue;
                }

                // if(lastWasOne == true) { explore 0s }
                int result = 0;
                for (int len = 1; len <= Math.min(zeroesLeft, limit); len++) {
                    result = (result + t[onesLeft][zeroesLeft - len][0]) % M;
                }
                t[onesLeft][zeroesLeft][1] = result;

                // else { explore 1s }
                result = 0;
                for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                    result = (result + t[onesLeft - len][zeroesLeft][1]) % M;
                }
                t[onesLeft][zeroesLeft][0] = result;
            }
        }

        int startWithOne = t[one][zero][0];
        int startWithZero = t[one][zero][1];

        return (startWithOne + startWithZero) % M;
    }
}