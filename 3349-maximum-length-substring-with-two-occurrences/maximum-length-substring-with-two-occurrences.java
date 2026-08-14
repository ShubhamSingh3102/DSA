class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int low = 0;
        int max = 0;

        for(int high = 0; high < s.length(); high++){
            freq[s.charAt(high) - 'a']++;
            while (freq[s.charAt(high) - 'a'] > 2){
                freq[s.charAt(low) - 'a']--;
                low++;
            }
            max = Math.max(max, high - low + 1);
        }
        return max;
    }
}