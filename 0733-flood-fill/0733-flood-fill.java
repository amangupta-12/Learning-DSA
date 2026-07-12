class Solution {
    class Pair{
        int row;
        int col;
        Pair(int _row,int _col){
            this.row =  _row;
            this.col = _col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m =  image[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
    int defaultclr = image[sr][sc]; 
    q.add(new Pair(sr,sc));
    image[sr][sc] = color;
    vis[sr][sc] = true;
             int[] drow = {-1,0,1,0};
            int[] dcol = {0,-1,0,+1};

        while(!q.isEmpty()){
           int r = q.peek().row;
           int c = q.peek().col;
           q.remove();
            for(int i=0;i<4;i++){
                    int nrow = r + drow[i];
                    int ncol = c + dcol[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                    && (!vis[nrow][ncol]) && image[nrow][ncol]==defaultclr){
                        image[nrow][ncol] = color;
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol] = true;
                    }
                }
            }
        
        return image;
    }
}