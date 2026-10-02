class Solution {
    public int[] minOperations(String boxes) {
        String[] ch = boxes.split("");

        int[] ans = new int[boxes.length()];

        for(int i = 0; i < ch.length; i++){
            for(int j = 0; j < ch.length; j++){

                if(ch[j].charAt(0) == '1'){
                    ans[i] += Math.abs(i - j);
                }
            }
        }
        return ans;
    }
}