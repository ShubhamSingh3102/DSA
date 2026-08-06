class Solution {
    public boolean validGrid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }

    static int[] x = {-1,1,0,0};
    static int[] y = {0,0,-1,1};


    public void dfs(char[][] adj, int n, int m, int i, int j){

        // visited....
        adj[i][j] = '#';

        for(int k = 0; k < 4; k++){
            int row = i + x[k];
            int col = j + y[k];


            if (validGrid(row,col,n,m) && adj[row][col] == 'O'){
                dfs(adj,n,m,row,col);
            }
        }
        return;
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int i, j;

        // boundary waale 0 se aapko dfs start krna h....
        // first row...
        for(j = 0; j < m; j++){
            if (board[0][j] == 'O'){
                dfs(board,n,m,0,j);
            }
        }

        // last row...
        for(j = 0; j < m; j++){
            if (board[n-1][j] == 'O'){
                dfs(board,n,m,n-1,j);
            }
        }

        // first col...
        for(i = 0; i < n; i++){
            if (board[i][0] == 'O'){
                dfs(board,n,m,i,0);
            }
        }

        // last col...
        for(i = 0; i < n; i++){
            if (board[i][m-1] == 'O'){
                dfs(board,n,m,i,m-1);
            }
        }

        // now # --> 'O'
        for(i = 0; i < n; i++){
            for(j = 0; j < m; j++){
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}