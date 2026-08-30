class Solution {

    private int solve(int x, int y, List<List<Integer>> triangle,
                      int[][] dp, boolean[][] visited) {

        if (x == triangle.size() - 1)
            return triangle.get(x).get(y);

        if (visited[x][y])
            return dp[x][y];

        int str = solve(x + 1, y, triangle, dp, visited);
        int dia = solve(x + 1, y + 1, triangle, dp, visited);

        visited[x][y] = true;

        return dp[x][y] =
            triangle.get(x).get(y) + Math.min(str, dia);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int m = triangle.size();

// as the value can be negative, so we cannot assign the dp -1 
// so we used visited array 

 // also we used the row size m bcz ,it can be maximum the length of the triangle       
        int[][] dp = new int[m][m];
        boolean[][] visited = new boolean[m][m];

        return solve(0, 0, triangle, dp, visited);
    }
}