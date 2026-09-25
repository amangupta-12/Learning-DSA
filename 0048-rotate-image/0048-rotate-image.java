class Solution {
    public void rotate(int[][] matrix) {
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(!vis[i][j]){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                vis[i][j] = true;
                vis[j][i] = true;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            int l = 0;
            int r = matrix[0].length-1;
            while(l<r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++; r--;
            }
        }

    }
}