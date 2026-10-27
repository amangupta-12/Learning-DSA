class Solution {
   
    int solve(int i , int j , int[][] grid){
        if(i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1){
            return 0;
        }
        if(grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        int up = solve(i-1,j,grid);
        int down = solve(i+1,j,grid);
        int left = solve(i,j-1,grid);
        int right = solve(i,j+1,grid);

        return 1 + up + down + left + right;
    }
    public int maxAreaOfIsland(int[][] grid) {
         int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    max = Math.max(solve(i,j,grid),max);
                }
            }
        }
        
        return max;
    }
}