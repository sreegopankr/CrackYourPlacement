// lettcode : https://leetcode.com/problems/knight-dialer/description/

class Solution {
    int[][] jumps = {
        {4,6},
        {8,6},
        {7,9},
        {4,8},
        {3,9,0},
        {},
        {1,7,0},
        {2,6},
        {1,3},
        {2,4}
    };
    int mod = 1000000007;
    int[][] dp = null;
    public int knightDialer(int n) {
        dp = new int[n][10];
        for(int cell=0; cell<10; cell++){
            dp[0][cell] = 1;
        }
        
        for(int i = 1; i<=n-1; i++){
            for(int cell = 0; cell<10; cell++){
                int ans=0;
                for(int next: jumps[cell]){
                    ans = (ans + dp[i-1][next])%mod;
                }
                dp[i][cell] = ans;
            }
        }

        int result=0;
        for(int cell = 0; cell<10; cell++){
            result = (result + dp[n-1][cell])%mod;
        }

        return result;
    }
    
}