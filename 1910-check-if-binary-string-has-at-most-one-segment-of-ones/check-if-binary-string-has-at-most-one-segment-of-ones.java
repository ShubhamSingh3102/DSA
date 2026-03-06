class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int count = 0;

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                // now traverse as a segment of one...
                count++;
                while (i < n && s.charAt(i) == '1') {
                    i++;
                }
            } else { // s.charAt(i) == '0'
                i++;
            }

            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}