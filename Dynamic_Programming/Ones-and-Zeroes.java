// leetcode:https://leetcode.com/problems/ones-and-zeroes/

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int[][] freqCount = new int[strs.length][2]; 

        int i=0;
        for(String s: strs){
            freqCount[i] = count(s);
            i++;
        }

        for(i=0;i<strs.length;i++){
            int zeroFreq = freqCount[i][0];
            int oneFreq = freqCount[i][1];

            for(int j=m; j>=zeroFreq;j--){
                for(int k=n; k>=oneFreq; k--){
                    dp[j][k] = Math.max(dp[j-zeroFreq][k-oneFreq]+1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] count(String str){
        int freq[] = new int[2];
        for(char c: str.toCharArray()){
            if(c == '0'){
                freq[0]++;
            }else{
                freq[1]++;
            }
        }
        return freq;
    }
}