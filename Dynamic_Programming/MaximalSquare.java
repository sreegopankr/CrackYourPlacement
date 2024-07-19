class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;
        //initialize dp array
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || j==0) && matrix[i][j] == '1'){
                    dp[i][j] = 1;
                    maxSide=Math.max(dp[i][j], maxSide);
                }
            }
        }
        //filling dp
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    maxSide=Math.max(dp[i][j], maxSide);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxSide*maxSide;
    }
}