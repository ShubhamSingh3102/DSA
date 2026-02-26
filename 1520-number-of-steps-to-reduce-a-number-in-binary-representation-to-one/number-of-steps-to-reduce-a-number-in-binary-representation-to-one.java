class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int ans = 0;

        for (int i = n - 1; i >= 1; i--) {
            if ((s.charAt(i) - '0' + carry) % 2 == 1) { // odd
                ans += 2;
                carry = 1; // right Shift and adding one...
            } else {
                ans += 1; // only right Shift 
            }
        }
        return ans + carry;
    }
}