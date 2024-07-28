
class Solution {
    private int[] memo; 
    public int climbStairs(int n) {
  // Initialize memo array
        memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return climbStairsHelper(n);
    }

    private int climbStairsHelper(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        // Check if the value is already computed
        if (memo[n] != -1) {
            return memo[n];
        }

        // Compute the value and store it in the array
        memo[n] = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
        return memo[n];
    }
}