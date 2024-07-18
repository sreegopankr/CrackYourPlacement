//leetcode: https://leetcode.com/problems/minimum-path-sum/

class Solution {
    int[][] dp = null;
    public int solver(int i, int j, int m, int n, int[][] grid){
        if(i==m && j==n){
            return grid[m][n];
        }
        if(i>m || j>n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int right = solver(i+1, j, m, n, grid);
        
        int down = solver(i, j+1, m, n, grid);

        int min = Math.min(right, down);

        dp[i][j] = min+grid[i][j];

        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j] = -1;
            }
        }
        int ans = solver(0, 0, row-1, col-1, grid);

        return ans;
    }
}