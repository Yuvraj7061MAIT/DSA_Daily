class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n]; 
        
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
                ans[j][(n - 1) - i] = matrix[i][j];
            }
        }

        // Copy the rotated matrix back to the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}
