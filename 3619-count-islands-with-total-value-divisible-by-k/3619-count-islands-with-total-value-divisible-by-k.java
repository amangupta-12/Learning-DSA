class Solution {
    
    long solve(int i , int j ,int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        
        if(grid[i][j] == 0){
            return 0;
        }
        int val = grid[i][j];
        grid[i][j] = 0;

        long down =   solve(i + 1, j, grid);
        long up =  solve(i - 1, j, grid);
        long left =  solve(i, j - 1, grid);
        long right =  solve(i, j + 1, grid);

        return val + up + down + left + right;
    } 

       
    public int countIslands(int[][] grid, int k) {
         int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != 0){
                    if(solve(i,j,grid)% k == 0){
                        count++;
                    }
                }
            }
            }
        return count;
    }
}