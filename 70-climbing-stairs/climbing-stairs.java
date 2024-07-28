class Solution {
    public int climbStairs(int n) {

        
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to stay at the ground (no steps)
        dp[1] = 1; // Base case: 1 way to reach the first step
        
        // Fill the dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n]; 
    }
}