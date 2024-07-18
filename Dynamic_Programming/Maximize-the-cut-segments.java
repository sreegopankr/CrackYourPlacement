//gfg: https://www.geeksforgeeks.org/problems/cutted-segments1642/1

class Solution
{
    int[] dp = null;
    // public int solve(int n, int x, int y, int z){
    //     //base case
    //     if(n == 0){
    //         return 0;
    //     }
    //     if(n<0){
    //         return Integer.MIN_VALUE;
    //     }
        
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
        
    //     int a = solve(n-x,x,y,z)+1;
    //     int b = solve(n-y,x,y,z)+1;
    //     int c = solve(n-z,x,y,z)+1;
        
    //     dp[n] = Math.max(a,Math.max(b,c));
        
    //     return dp[n];
    // }
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       dp = new int[n+1];
       for(int i = 0; i<=n; i++){
           dp[i] = -1;
       }
       
       dp[0] = 0;
       
       for(int i=1;i<=n; i++){
           if(i-x>=0 && dp[i-x]!=-1){
               dp[i] = Math.max(dp[i],dp[i-x]+1);
           }
           if(i-y>=0 && dp[i-y]!=-1){
               dp[i] = Math.max(dp[i],dp[i-y]+1);
           }
           if(i-z>=0 && dp[i-z]!=-1){
               dp[i] = Math.max(dp[i], dp[i-z]+1);
           }
       }
       
       if(dp[n]<0){
           return 0;
       }
       return dp[n];
    }
}