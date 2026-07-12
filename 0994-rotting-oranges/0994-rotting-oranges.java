class Solution {
    // we are storing the time bcz to know how much time takes to rotten all the oranges 
    // so we will intialize all the rotten ones to 0. 
    class Pair{
    int row;
    int col;
    int tm;
        Pair(int _row,int _col,int _tm){
            this.row = _row;
            this.col= _col;
            this.tm = _tm;
        }
    }
    // As we have to find the min time to rotten all the oranges so we need to traverse level by level 
    // So we will use bfs to find the time.
    public int orangesRotting(int[][] grid) {
        int n  =  grid.length;
        int m  =  grid[0].length;
        boolean[][] visited = new boolean[n][m]; 
        Queue<Pair> q = new LinkedList<>();
        int freshcnt = 0;
// Make true to all the rotten oranges 
// Also we will count the freshones so after following the process we will check the count of the freshone and the one we rottened
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = true;
                }else{
                    visited[i][j] = false;
                }
                if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }
// we are creating delta arrays to store the dimension of the neighbour rol col 
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,-1,0,+1};
        int tm = 0;
        int cnt = 0;
            while(!q.isEmpty()){
                int r = q.peek().row;
                int c = q.peek().col;
                int t = q.peek().tm;
                tm = Math.max(tm,t);
                q.remove();
                for(int i=0;i<4;i++){
                    int nrow = r + drow[i];
                    int ncol = c + dcol[i];
                 if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                 && grid[nrow][ncol]==1 && (!visited[nrow][ncol])){
                    q.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol] = true;
                    cnt++;
                 }   
                }
            }
                if(cnt != freshcnt) return -1;
            
        return tm;
    }
}