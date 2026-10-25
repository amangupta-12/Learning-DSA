class Solution {

    boolean solve(int i , int j ,int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        
        if(grid[i][j] == 1){
            return true;
        }
        grid[i][j] = 1;
        
        boolean down = solve(i + 1, j, grid);
        boolean up = solve(i - 1, j, grid);
        boolean left = solve(i, j - 1, grid);
        boolean right = solve(i, j + 1, grid);

        return up && down && left && right;
    } 
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    if(solve(i,j,grid)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}