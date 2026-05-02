class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        // Variable Window Size
        int low = 0;
        int high = 0;
        int result = Integer.MIN_VALUE;
        int maxCount = 0;

        while (high < s.length()) {
            char ch = s.charAt(high);
            freq[ch - 'A']++; // A -> 65, B --> 66

            int len = high - low + 1;
            maxCount = Math.max(maxCount, freq[ch - 'A']);
            int diff = len - maxCount;

            // jab tk ye information galat hai tb tk low ++ hoga...
            while (diff > k) { // galat hai....
                char leftChar = s.charAt(low);
                freq[leftChar - 'A']--;
                low++;

                maxCount = Math.max(maxCount, freq[ch - 'A']);
                len = high - low + 1;
                diff = len - maxCount;
            }
            // diff < k or diff == k  ---> right information
            len = high - low + 1;
            result = Math.max(result, len);
            high++;
        }
        return result;
    }
}