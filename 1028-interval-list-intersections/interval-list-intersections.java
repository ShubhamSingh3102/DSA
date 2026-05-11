class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length){
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            // ye to aacha case hai...
            if(start1 <= start2){
                // now check for overlap and tabhi toh intersection hoga..
                if(end1 >= start2){ // overlap
                    // aab intersect kro
                    int start = Math.max(start1,start2);
                    int end = Math.min(end1,end2);
                    // push back to ans
                    res.add(new int[]{start,end});
                }
            } else { // start1 >= start2
                if(end2 >= start1){
                    // aab intersect kro
                    int start = Math.max(start1,start2);
                    int end = Math.min(end1,end2);
                    // push back to ans
                    res.add(new int[]{start,end});
                }
            }
            // i ko badhae ki j ko badhae...
            //// jo phele khatam hoga usko badhao...
            if(end1 <= end2){
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}