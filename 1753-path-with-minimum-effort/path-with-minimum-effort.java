class Solution {
    public class Pair {

        int diff;
        int row;
        int col;

        Pair(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
    static int[] x = {1,-1,0,0};
    static int[] y = {0,0,1,-1};

    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        // max absolute Diff....
        int n = heights.length;
        int m = heights[0].length;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            res.add(new ArrayList<>());

            for(int j = 0; j < m; j++){
                res.get(i).add(Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.diff, b.diff)
        );

        // initially source ka distance zero h...
        res.get(0).set(0,0);

        pq.add(new Pair(0,0,0));

        while (!pq.isEmpty()){
            Pair p = pq.poll();

            int diff = p.diff;
            int row = p.row;
            int col = p.col;

            if(diff > res.get(row).get(col)){
                continue;
            }

            for(int k = 0; k < 4; k++){
                int r = row + x[k];
                int c = col + y[k];

                if(!isValid(r,c,n,m)){
                    continue;
                }
                int absDiff = Math.abs(heights[row][col] - heights[r][c]);
                int newWeight = Math.max(absDiff, diff);

                // relaxation
                if(newWeight < res.get(r).get(c)){
                    res.get(r).set(c,newWeight);

                    pq.add(new Pair(newWeight,r,c));
                }
            }
        }
        return res.get(n-1).get(m-1);
    }
}