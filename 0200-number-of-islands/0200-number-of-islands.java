class Solution {

    private void dfs(int a,int b,boolean[][] vis,char[][] grid){
        int n  = grid.length;
        int m =  grid[0].length;
        vis[a][b] = true;
        int[] dirx = {0,-1,0,+1};
        int[] diry = {-1,0,+1,0};
        for(int i=0;i<4;i++){
            int row = a + dirx[i];
            int col = b + diry[i];
                if(row>=0 && row<n && col>=0 && col<m
                 && grid[row][col] == '1' && (!vis[row][col])){
                    dfs(row,col,vis,grid);
                }
            }
        
    }
    public int numIslands(char[][] grid) {
        int n  = grid.length;
        int m =  grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int islands = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((!vis[i][j]) && grid[i][j] == '1'){
                    dfs(i,j,vis,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}