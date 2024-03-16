class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = 1; // Base case: LIS for the first element is 1

        // Dynamic programming approach
        for (int i = 1; i < n; i++) {
            dp[i] = 1; // Initialize LIS for each element to 1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update LIS for current element
                }
            }
        }

        // Find the maximum LIS in the array
        int maxLIS = dp[0]; // Initialize maxLIS with the first element of dp
        for (int i = 1; i < n; i++) {
            maxLIS = Math.max(maxLIS, dp[i]); // Update maxLIS if dp[i] is greater
        }

        return maxLIS;
    }
}
