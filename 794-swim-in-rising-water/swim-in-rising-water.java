class Solution {
    public class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }

    static int[] x = {1,-1,0,0};
    static int[] y = {0,0,1,-1};

    public boolean bfs(int[][] grid,int n,int m, int money){

        if(grid[0][0] > money){
            return false;
        }

        Queue<Pair> q = new LinkedList<>();

        ArrayList<ArrayList<Integer>> visited = new ArrayList<>();

        for(int i = 0; i < n; i++){
            visited.add(new ArrayList<>());

            for(int j = 0; j < m; j++){
                visited.get(i).add(0);
            }
        }

        q.add(new Pair(0,0));

        visited.get(0).set(0,1);

        while (!q.isEmpty()){
            Pair p = q.poll();

            int row = p.first;
            int col = p.second;

            if(row == n - 1 && col == m - 1){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int r = row + x[i];
                int c = col + y[i];

                if(isValid(r,c,n,m) && visited.get(r).get(c) == 0 && money >= grid[r][c]){
                    q.add(new Pair(r,c));

                    visited.get(r).set(c,1);
                }
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int low = grid[0][0];

        int high = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                high = Math.max(high,grid[i][j]);
            }
        }

        int res = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;

            if(bfs(grid,n,m,mid)){
                res = mid;

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}