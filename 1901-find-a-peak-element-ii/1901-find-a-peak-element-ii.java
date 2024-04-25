class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int col = 0; col < n; col++) {
            int maxRow = 0;
            for (int row = 0; row < m; row++) {
                if (mat[row][col] > mat[maxRow][col]) {
                    maxRow = row;
                }
            }

            if ((col == 0 || mat[maxRow][col - 1] <= mat[maxRow][col]) &&
                (col == n - 1 || mat[maxRow][col + 1] <= mat[maxRow][col])) {
                return new int[]{maxRow, col};
            }
        }

        return new int[]{-1, -1}; // Not found (shouldn't happen given the constraints)
    }
}
