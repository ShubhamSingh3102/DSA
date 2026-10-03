class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;

        int result = 0;
        for(int biPos = 0; biPos < 32; biPos++){
            int count = 0;

            for(int num = 0; num < n; num++){
                //  left shift...
                if((candidates[num] & (1 << biPos)) != 0){
                    count++;
                }
            }
            result = Math.max(result,count);
        }
        return result;
    }
}