class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return findPaths(0, 0, m, n, memo);
    }

    private int findPaths(int i, int j, int m, int n, int[][] memo) {
        // Base case: If the robot reaches the bottom-right corner
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        // If the robot moves out of the grid boundaries
        if (i >= m || j >= n) {
            return 0;
        }
        // If the result is already computed, return it
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        // Move right and down
        memo[i][j] = findPaths(i + 1, j, m, n, memo) + findPaths(i, j + 1, m, n, memo);
        return memo[i][j];
    }
}
