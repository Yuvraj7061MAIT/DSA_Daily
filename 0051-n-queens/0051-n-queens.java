import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
      
        List<List<String>> result = new ArrayList<>();
        char board [][] = new char[n][n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }
        
        helper(board , 0 , result);
        return result;
    }
    
    private void helper(char board[][] , int row ,List<List<String>> result){
        
        //base case
        if(row == board.length){
            result.add(Solution(board));
            return;
        }
        
        for(int col = 0 ; col < board.length ; col++){
            if(isValid(board , row , col)){
                board[row][col] = 'Q';
                helper(board , row+1 , result);
                board[row][col] = '.';
            }
        }
        
    }
    
    private boolean isValid(char[][] board , int row ,int col){
        
        
        //st. line
        for(int  i = 0 ; i < row ; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        //left Upper Limit
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        //right Upper Limit
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        return true;
        
    }
    
    private List<String> Solution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(String.valueOf(row));
        }
        return solution;
    }
    
}