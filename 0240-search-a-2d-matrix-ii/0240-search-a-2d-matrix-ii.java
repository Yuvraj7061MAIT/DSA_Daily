class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false; // Matrix is empty
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int row = 0; 
        int col = cols - 1;
        
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target)
                return true; // Found the target
            
            if (matrix[row][col] < target)
                row++; // Move to the next row if current element is smaller than target
            else
                col--; // Move to the previous column if current element is larger than target
        }
        
        return false; // Target not found
    }
}
