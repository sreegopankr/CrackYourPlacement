class Solution {
    public long solve(char[][] keypad, int i, int j, int n, long[][][] dp){
        if(i>=4 || j>=3 || i<0 || j<0){
            return 0;
        }
        if(keypad[i][j]=='*' || keypad[i][j]=='#'){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        
        if(dp[i][j][n]!=-1){
            return dp[i][j][n];
        }
        
        return dp[i][j][n] = solve(keypad, i, j, n-1, dp) +
                             solve(keypad, i-1, j, n-1, dp) +
                             solve(keypad, i, j-1, n-1, dp) +
                             solve(keypad, i+1, j, n-1, dp) +
                             solve(keypad, i, j+1, n-1, dp) ;
    }
    public long getCount(int n) {
        // Your code goes here
        char[][] keypad = {
            {'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}
        };
        long[][][] dp = new long[4][3][n+1];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < n+1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        long count = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(keypad[i][j]!='*' && keypad[i][j]!='#'){
                    count+=solve(keypad, i, j, n, dp);
                }
            }
        }
        return  count;
    }
}