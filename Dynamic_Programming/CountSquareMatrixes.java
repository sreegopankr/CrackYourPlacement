class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int total = 0;
        //initialize dp array
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j];
                    total+=dp[i][j];
                }
            }
        }
        //filling dp
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    total+= dp[i][j];
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return total;
    }
}