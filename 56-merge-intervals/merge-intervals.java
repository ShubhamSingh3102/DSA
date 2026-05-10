class Solution {
    public int[][] merge(int[][] intervals) {
        // sort on the basis of starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList<>();

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            // overlap
            if (end1 >= start2) {

                // merge
                // [start1 , Math.max(end1, end2)]

                end1 = Math.max(end1, end2);

            } else {
                // no overlap

                ans.add(new int[] { start1, end1 });

                // update start1 and end1
                start1 = start2;
                end1 = end2;
            }
        }
        // last interval add karna mat bhoolna
        ans.add(new int[] { start1, end1 });

        return ans.toArray(new int[ans.size()][]);
    }
}