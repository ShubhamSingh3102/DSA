class Solution {
    public String minWindow(String s, String t) {
        int[] have = new int[128]; // s
        int[] needed = new int[128]; // t ko traverse kr lijia

        // t ka frequency ko store kr lo....
        for (char ch : t.toCharArray()) {
            needed[ch]++;
        }

        int low = 0;
        int high = 0;
        int count = 0; //// kitne character match hue...
        int result = Integer.MAX_VALUE;
        int start = 0;

        while (high < s.length()) {
            char ch = s.charAt(high);
            have[ch]++;

            // if character is needed then count++
            if (needed[ch] > 0 && have[ch] <= needed[ch]) {
                count++;
            }

            // jab tk sahi h then low ++
            while (count == t.length()) {

                int len = high - low + 1;

                if (result > len) {
                    result = len;
                    start = low;
                }

                char leftChar = s.charAt(low);
                have[leftChar]--;

                if (needed[leftChar] > 0 && have[leftChar] < needed[leftChar]) {
                    count--;
                }

                low++;
            }
            high++;
        }
        return (result == Integer.MAX_VALUE) ? "" : s.substring(start, start + result);
    }
}