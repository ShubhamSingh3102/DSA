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
    public int swimInWater(int[][] grid) {
        // max absolute Diff....
        int n = grid.length;
        int m = grid[0].length;

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
        res.get(0).set(0,grid[0][0]);

        // (money, {x,y})
        pq.add(new Pair(grid[0][0],0,0));

        while (!pq.isEmpty()){
            Pair p = pq.poll();

            int money = p.diff;
            int row = p.row;
            int col = p.col;

            if(row == n - 1 && col == m - 1){
                return money;
            }
            // Stale Entry
            if(money > res.get(row).get(col)){
                continue;
            }

            for(int k = 0; k < 4; k++){
                int r = row + x[k];
                int c = col + y[k];

                if(!isValid(r,c,n,m)){
                    continue;
                }

                int newMoney = Math.max(money,grid[r][c]);

                // relaxation
                if(newMoney < res.get(r).get(c)){
                    res.get(r).set(c,newMoney);

                    pq.add(new Pair(newMoney,r,c));
                }
            }
        }
        return res.get(n-1).get(m-1);
    }
}