// leetcode: https://leetcode.com/problems/counting-bits/description/

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<n+1; i++){
            if(i%2 == 0){ //even
                ans[i] = ans[i/2];
            }else{ // odd
                ans[i] = ans[i/2] + 1;
            }
        }
        return ans;
    }
}