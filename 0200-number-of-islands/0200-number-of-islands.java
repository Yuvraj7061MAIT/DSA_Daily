class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0 || grid == null){
            return 0;
        }
        
        int Island = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    Island++;
                    dfs(grid , i , j);
                }
            }
        }
        
        return Island;
        
    }
    
    public void dfs(char[][] grid , int  i , int j){
        
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        } 
           
        grid[i][j] = '0';
        
        // Check all four directions
        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
            
    }
}