class Solution {
    public static int LongestCommonSubsequence(String str1,String str2){
        int n = str1.length();
        int m = str2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        //// base case...
        for (int i = 0; i <= m; i++){
            prev[i] = 0;
        }
        for(int ind1 = 1; ind1 <= n;ind1++){
            for(int ind2 = 1;ind2 <= m;ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                    curr[ind2] = 1 + prev[ind2-1];
                }else{
                    curr[ind2] = Math.max(prev[ind2],curr[ind2-1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
    public static int longestPalindromicSubsequence(String s){
        String t = new StringBuilder(s).reverse().toString();
        return LongestCommonSubsequence(s,t);

    }
    public int minInsertions(String s) {
        return s.length() - longestPalindromicSubsequence(s);
    }
}