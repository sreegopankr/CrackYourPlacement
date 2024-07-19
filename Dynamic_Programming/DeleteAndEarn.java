class Solution {
    public int deleteAndEarn(int[] nums) {
        int freq[] = new int[10001];
        int dp[] = new int[10001];

        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }

        dp[0] = 0;
        dp[1] = 1 * freq[1];

        for(int i =2; i<10001; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+freq[i]*i);
        }
        return dp[10000];
    }
}