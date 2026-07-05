class Solution {
    class Pair{
        int first;
        int second;

        public Pair(int r, int c){
            this.first = r;
            this.second = c;
        }
    }
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (grid[i][j] == 2){
                    q.add(new Pair(i,j));
                    grid[i][j] = -2;
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};

        while (!q.isEmpty() && fresh > 0){
            time++;

            int s = q.size();

            while (s-- > 0){
                Pair p = q.peek();
                q.poll();

                int r = p.first;
                int c = p.second;

                for(int k = 0; k < 4; k++){
                    int row = r + x[k];
                    int col = c + y[k];

                    if (isValid(row,col,n,m) && grid[row][col] == 1){
                        q.add(new Pair(row,col));
                        grid[row][col] = -2;
                        fresh--;
                    }
                }
            }
        }
        if (fresh > 0){
            return -1;
        }
        return time;
    }
}