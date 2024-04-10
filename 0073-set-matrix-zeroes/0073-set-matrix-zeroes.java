public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Variables to track whether the first row and first column should be zeroed out
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // Check if the first row contains any zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // Check if the first column contains any zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // Use the first row and first column to mark which rows and columns should be zeroed out
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the corresponding row
                    matrix[0][j] = 0; // Mark the corresponding column
                }
            }
        }
        
        // Zero out rows based on the values in the first column (except the first row)
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Zero out columns based on the values in the first row (except the first column)
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix1);
        printMatrix(matrix1); // Output: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
        
        // Example 2
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix2);
        printMatrix(matrix2); // Output: [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
    }
    
    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
