/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        
        return bst(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
        
    }
    
    
    private TreeNode bst(int[] preorder , int min , int max){
        
        // base case
        if(index >= preorder.length){
            return null;
        }
        
        int val = preorder[index];
        if(val < min || val > max ){
            return null;
        }
        
        TreeNode node = new TreeNode(val);
        index++;
        
        node.left = bst(preorder , min , val);
        node.right = bst(preorder , val , max);
        
        return node;
        
    }
}