class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Perform DFS to search for the word
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // Check if we found all characters of the word
        if (index == word.length()) {
            return true;
        }
        
        // Check if the current cell is out of bounds or doesn't match the word character
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Explore neighboring cells recursively
        boolean found = dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1);
        
        // Restore the original value of the cell
        board[i][j] = temp;
        
        return found;
    }
}
