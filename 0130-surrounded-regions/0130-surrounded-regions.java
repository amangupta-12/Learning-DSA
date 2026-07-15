class Solution {
    
    public void dfs(int r,int c,boolean[][] vis,boolean[][] mat,char[][] grid){

        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = true;
        
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i=0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                !vis[nrow][ncol] && grid[nrow][ncol]=='O'){
                mat[nrow][ncol] = true;
                dfs(nrow,ncol,vis,mat,grid);
            }
        }
    }

    public void solve(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        boolean[][] mat = new boolean[n][m];

      for(int i=0;i<m;i++){
        // first row 
        if(!vis[0][i] && grid[0][i]=='O'){
            mat[0][i] = true;
            dfs(0,i,vis,mat,grid);
        }
        // last row 
         if(!vis[n-1][i] && grid[n-1][i]=='O'){
            mat[n-1][i] = true;
            dfs(n-1,i,vis,mat,grid);
        }
      }

      for(int i=0;i<n;i++){
        // first col 
        if(!vis[i][0] && grid[i][0]=='O'){
            mat[i][0] = true;
            dfs(i,0,vis,mat,grid);
        }
        // last col
         if(!vis[i][m-1] && grid[i][m-1]=='O'){
            mat[i][m-1] = true;
            dfs(i,m-1,vis,mat,grid);
        }
      }

        for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        if(grid[i][j]=='O' && !mat[i][j]){
            grid[i][j]='X';
        }
    }
}

    }
}